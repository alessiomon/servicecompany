/*package com.example.servicecompany.sevice;


import com.example.servicecompany.exception.ResourceNotFoundException;
import com.example.servicecompany.model.CompanyOwner;
import com.example.servicecompany.model.Employee;
import com.example.servicecompany.model.User;
import com.example.servicecompany.repository.CompanyOwnerRepository;
import com.example.servicecompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CompanyOwnerSeviceImpl implements CompanyOwnerService {

    @Autowired
    private UserRepository userRepository;
    private EmployeeService employeeService;

    @PostConstruct
    public void initializeCompanyOwnerTable() {
        userRepository.saveAll(
                Stream.of(
                        new CompanyOwner("orbyta"),
                        new CompanyOwner("Bancasella")

                ).collect(Collectors.toList()));
     ///   new CompanyOwner("Bancasella", "s345678")
    }

    public CompanyOwner addCompanyOwner(CompanyOwner companyOwner){
        return userRepository.save(companyOwner);
    }

    public void deleteCompany(Long id){
        User companyOwner=getCompanyOwnerbyId(id);
        userRepository.delete(companyOwner);
    }

    public User getCompanyOwnerbyId(Long companyId) {
        return userRepository
                .findById(companyId).orElseThrow(() -> new ResourceNotFoundException("User" , "Id", companyId));
    }
 /// trovare un modo per fare le eccezioni, fare in un secondo momento
/*
    public CompanyOwner getCompanyOwnerByUsername(String username) {
        return companyOwnerRepository
                .findByUsername(username);
    }

 */


/*

    public List<User> getAllCompanyOwner() {
        return userRepository.findAll();
    }


    public  CompanyOwner editCompanyOwner(Long id, CompanyOwner companyOwner){
        CompanyOwner companyOwnertoEdit = getCompanyOwnerbyId(id);
        companyOwnertoEdit.setName(companyOwnertoEdit.getName());
        return companyOwnertoEdit;
    }

    public CompanyOwner addEmployeetoCompany(Long companyId , Long employeeId){

        CompanyOwner companyOwner = getCompanyOwnerbyId(companyId);
        Employee employee = employeeService.getEmployee(employeeId);
        companyOwner.addEmployee(employee);
        return companyOwner;

    }
    public CompanyOwner removeEmployeefromCompany(Long companyId , Long employeeId){
        CompanyOwner companyOwner = getCompanyOwnerbyId(companyId);
        Employee employee = employeeService.getEmployee(employeeId);
        companyOwner.removeEmployee(employee);
        return companyOwner;
    }

}

 */

