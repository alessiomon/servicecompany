package com.example.servicecompany.sevice;

import com.example.servicecompany.exception.ResourceNotFoundException;
import com.example.servicecompany.model.CompanyOwner;
import com.example.servicecompany.model.Employee;
import com.example.servicecompany.model.User;
import com.example.servicecompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @PostConstruct
    public void initializeTable() {
        repo.saveAll(
                Stream.of(
                new CompanyOwner("fred"),
                new CompanyOwner("steve"),
                new Employee("john", 20000),
                new Employee("mak", 55000),
                new Employee("peter", 120000)
        ).collect(Collectors.toList()));
    }

    @Override
    public List<User> getAllUser() {
        return repo.findAll();
    }

    @Override
    public List<User> getALLCompanyOwner() {
        return repo.findAll().stream().filter(e->e.roleName.equals("companyOwner")).toList();
    }

    @Override
    public List<User> getALLEmployees() {
        return repo.findAll().stream().filter(e->e.roleName.equals("employee")).toList();
    }

    @Override
    public User getUserbyId(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User" , "Id", id));
    }

    @Override
    public User getEmployee(Long id) {
        return null;
    }

    @Override
    public User getCompany(Long id) {
        return null;
    }

    @Override
    public User addCompany(CompanyOwner companyOwner) {
        return repo.save(companyOwner);
    }

    @Override
    public User addEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public void deleteUser(Long id) {
        repo.deleteById(id);

    }

    @Override
    public User addCompanyOwner(CompanyOwner companyOwner) {
        return null;
    }

    @Override
    public User getCompanyOwnerbyId(Long companyId) {
        return null;
    }

    @Override
    public void deleteCompany(Long id) {

    }

    @Override
    public User editCompanyOwner(Long id, CompanyOwner companyOwner) {
        return null;
    }

    @Override
    public User addEmployeetoCompany(Long companyId, Long employeeId) {
        return null;
    }

    @Override
    public User removeEmployeefromCompany(Long companyId, Long employeeId) {
        return null;
    }
}
