/*package com.example.servicecompany.sevice;

import com.example.servicecompany.exception.ResourceNotFoundException;
import com.example.servicecompany.model.CompanyOwner;
import com.example.servicecompany.model.Employee;
import com.example.servicecompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void initializeEmployeeTable() {
        employeeRepository.saveAll(
                Stream.of(
                        new Employee("john", 20000),
                        new Employee("mak", 55000),
                        new Employee("peter", 120000)
                ).collect(Collectors.toList()));
    }



    public Employee getEmployee(Long employeeId) {
        return employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee" , "Id", employeeId));
    }

    public void  deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository
                .findAll();
    }
    public Employee addEmployee(Employee newEmployee){

        return employeeRepository.save(newEmployee);

    }




}

 */
