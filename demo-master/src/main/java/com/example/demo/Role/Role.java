package com.example.demo.Role;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String description;
}

    //insert into role (id, description, name) values (1, "role padrao", "USER");

        //insert into role (id, description, name) values (2, "role adm", "ADMIN")