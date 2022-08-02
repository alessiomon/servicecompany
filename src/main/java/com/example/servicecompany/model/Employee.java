package com.example.servicecompany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Employee_user")
@NoArgsConstructor
@Data
public class Employee extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private double salary;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyOwner_id")
    private CompanyOwner companyOwner;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        super.roleName="employee";
    }



    public Employee(String name, double salary, CompanyOwner companyOwner) {
        this.name = name;
        this.salary = salary;
        super.roleName="employee";
        this.companyOwner= companyOwner;
    }
}