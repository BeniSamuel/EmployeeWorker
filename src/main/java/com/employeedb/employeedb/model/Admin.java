package com.employeedb.employeedb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    public Admin () {};
    public Admin ( String name, String email, String password ) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getName () { return this.name; }
    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }

}
