package com.example.servicecompany.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name="User")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class  User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "roleName")
    public String roleName;
    public int getId(){
        return id;
    }

}
