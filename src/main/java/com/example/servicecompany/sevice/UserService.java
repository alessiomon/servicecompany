package com.example.servicecompany.sevice;

import com.example.servicecompany.model.CompanyOwner;
import com.example.servicecompany.model.Employee;
import com.example.servicecompany.model.User;
import org.keycloak.jose.jwk.JWK;

import java.util.List;

public interface UserService {

   /// void initializeTable();

    ///get list
    List<User> getAllUser();
    List<User> getALLCompanyOwner();
    List<User> getALLEmployees();


    ///get by id
    User getUserbyId(Long id);

    User getEmployee(Long id);

    User getCompany(Long id);

    ///Add
    User addCompany(CompanyOwner companyOwner);
    User addEmployee(Employee employee);

    void deleteUser(Long id);






/*

    User addCompanyOwner(CompanyOwner companyOwner);

    User getCompanyOwnerbyId(Long companyId);
    /// CompanyOwner getCompanyOwnerByUsername(String username);
    ///  void initializeCompanyOwnerTable();
    void deleteCompany(Long id);

    User editCompanyOwner(Long id, CompanyOwner companyOwner);
    User addEmployeetoCompany(Long companyId , Long employeeId);
    User removeEmployeefromCompany(Long companyId , Long employeeId);

 */
}
