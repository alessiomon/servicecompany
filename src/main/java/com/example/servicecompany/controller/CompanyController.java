package com.example.servicecompany.controller;

import com.example.servicecompany.model.Admin;

import com.example.servicecompany.model.CompanyOwner;
import com.example.servicecompany.sevice.CompanyOwnerService;
import com.example.servicecompany.sevice.EmployeeService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private EmployeeService employeeService;

    private CompanyOwnerService companyOwnerService;

    public CompanyController(CompanyOwnerService companyOwnerService, EmployeeService employeeService)
    {
        super();
        this.companyOwnerService = companyOwnerService;
        this.employeeService= employeeService;
    }



    /// GET ALL COMPANY
    @GetMapping
    ///@PreAuthorize("hasRole('" + Admin.roleName +")")
    @RolesAllowed("admin")
    public ResponseEntity<List<CompanyOwner>> loadAllCompanies()
    {
        return ResponseEntity.ok(companyOwnerService.getAllCompanyOwner());
    }


    /// GET A SPECIFIC COMPANY
    @GetMapping("/{company_id}")
    @PreAuthorize ("hasRole('"+CompanyOwner.roleName+"')" + "|| hasRole('" + Admin.roleName + "')")
    public ResponseEntity<CompanyOwner> getCompanyOwnerbyId(@PathVariable ("company_id")  Long company_id ) throws AccessDeniedException{
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof Admin){
            if(((Admin)principal).getCompanyOwnersManagedByTheAdmin().contains(companyOwnerService.getCompanyOwnerbyId(company_id)))
                return ResponseEntity.ok(companyOwnerService.getCompanyOwnerbyId(company_id));
            else throw new AccessDeniedException("Access denied");
        }

        return ResponseEntity.ok(companyOwnerService.getCompanyOwnerbyId(company_id));
        }

    // DELETE COMPANY

    @DeleteMapping("/{company_id}")
    @PreAuthorize("hasRole('" + Admin.roleName + "')")
    public ResponseEntity<String> deleteCompany (@PathVariable("company_id") Long id)
    {
        companyOwnerService.deleteCompany(id);
        return new ResponseEntity<String>("Company deleted succesfully", HttpStatus.OK);
    }

    /// ADD COMPANY


    @PostMapping()
    @PreAuthorize("hasRole('" + Admin.roleName +")")
    public ResponseEntity<CompanyOwner> addCompanyowner(@RequestBody CompanyOwner companyOwner)
    {
        return new  ResponseEntity<CompanyOwner>(companyOwnerService.addCompanyOwner(companyOwner), HttpStatus.CREATED);
    }


    /// Modify Company _id
    @PutMapping("/{company_id}")
    @PreAuthorize("hasRole('" + Admin.roleName +")")
    public ResponseEntity<CompanyOwner> editCompanyOwner(@PathVariable Long id,
                                                             @RequestBody CompanyOwner companyOwner)
    {
        return new ResponseEntity<CompanyOwner>(companyOwnerService.editCompanyOwner(id,companyOwner),HttpStatus.OK);
    }

    @PostMapping("/{company_id}/employees/{employee_id}/add")
    @PreAuthorize (" authentication.principal.equals(#username)"+ "|| hasRole('" + Admin.roleName + "')")
    public ResponseEntity<CompanyOwner> addEmployeetoCompany(Long companyId , Long employeeId)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof Admin){
            if(((Admin)principal).getCompanyOwnersManagedByTheAdmin().contains(companyOwnerService.getCompanyOwnerbyId(companyId)))
                return ResponseEntity.ok(companyOwnerService.getCompanyOwnerbyId(companyId));
            else throw new AccessDeniedException("Access denied");
        }
     return new ResponseEntity<CompanyOwner>(companyOwnerService.addEmployeetoCompany(companyId, employeeId), HttpStatus.OK);
    }


    @DeleteMapping("/{company_id}/employees/{employee_id}/remove")
    @PreAuthorize("hasRole('" + Admin.roleName +")")
    public ResponseEntity<CompanyOwner> removeEmployeefromCompany(Long companyId , Long employeeId)
    {
        return new ResponseEntity<CompanyOwner>(companyOwnerService.removeEmployeefromCompany(companyId, employeeId), HttpStatus.OK);
    }

}
/*
    private CompanyOwnerService companyOwnerService;
    private Admin admin;

    public CompanyController(CompanyOwnerService companyOwnerService) {
        super();
        this.companyOwnerService = companyOwnerService;
    }

    @PostMapping()
    @RolesAllowed("maintainer")
    public ResponseEntity<CompanyOwner> saveCompany(@RequestBody CompanyOwner company) {
        return new ResponseEntity<CompanyOwner>(companyOwnerService.saveCompany(company), HttpStatus.CREATED);

    }

    //build get all employees
    @GetMapping
    @RolesAllowed("maintainer")
    public List<CompanyOwner> getAllCompany() {
        return companyOwnerService.getAllCompanyOwner();
    }

    // build get employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    @PreAuthorize("authentication.principal.username == #username) || ('Admin')")
    public ResponseEntity<CompanyOwner> getEmployeeById(@PathVariable("id") Long id) {
        return new ResponseEntity<CompanyOwner>(companyOwnerService.getCompanyOwnerbyId(id), HttpStatus.OK);

    }

    // build update employee rest api
    ///  @PutMapping("{id}")
    //7   public ResponseEntity<Company> updateCompany(@PathVariable("id") Long id
    ///        , @RequestBody Company company) {
    ///  return new ResponseEntity<Company>(companyService.updateCompany(company, id), HttpStatus.OK);}

    ///build delete employee rest API
    @DeleteMapping("{id}")
    @RolesAllowed("maintainer")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id) {
        companyOwnerService.deleteCompany(id);
        return new ResponseEntity<String>("Company deletes succesfully", HttpStatus.OK);

 */
