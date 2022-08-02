package com.example.servicecompany.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@MappedSuperclass
public abstract class  User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;

    @Column(name = "roleName")
    public String roleName;
    public Long getId(){
        return id;
    }

}
