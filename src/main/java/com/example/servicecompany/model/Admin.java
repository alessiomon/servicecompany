/* package com.example.servicecompany.model;


import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private final int id=0;

    @Column(name = "Istance")
    private static Admin Istance = null;

    @Column(name = "roleName")
    public final static String roleName = "admin";

    @OneToMany(mappedBy = "admin")
    private List<CompanyOwner> companyOwnersManagedByTheAdmin= new ArrayList<>();

    public void addOwner(CompanyOwner owner) {
        companyOwnersManagedByTheAdmin.add(owner);}

    public Admin(){
    };

    public Admin getIstance(){
        if(Istance==null) Istance= new Admin();
        return Istance;

    }

}

 */
