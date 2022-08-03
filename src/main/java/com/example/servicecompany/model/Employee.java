package com.example.servicecompany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Employee_user")
@NoArgsConstructor
public class Employee extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private double salary;


    @ManyToOne(fetch = FetchType.LAZY)
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