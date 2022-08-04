package com.example.servicecompany.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "companyOwner_user")
@NoArgsConstructor
@Data
public class CompanyOwner extends User{

    @Column(name = "name")
    private String name;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "companyOwner")
    private List<Employee> employeesOfTheCompany= new ArrayList<>();

    public CompanyOwner(String name){

        this.name = name;
        super.roleName="companyOwner";
    }

    public Collection<Employee> getEmployeesOfTheCompany(){
        return this.employeesOfTheCompany;
    }
    public void addEmployee(Employee employee){
        employeesOfTheCompany.add(employee);
    }

    public void removeEmployee(Employee employee){
        employeesOfTheCompany.remove(employee);
    }
}
