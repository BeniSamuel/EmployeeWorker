package com.employeedb.employeedb.model;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int id;
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private int phone;

    // Constructors
    public Employee() {}

    public Employee ( String name, String email, int phone ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public void setId ( int id ) { this.id = id; }
    public void setName ( String name ) { this.name = name; }
    public void setEmail ( String email ) { this.email = email; }
    public void setPhone ( int phone ) { this.phone = phone; }

    public int getId () { return this.id; }
    public String getName () { return this.name; }
    public String getEmail () { return this.email; }
    public int getPhone () { return this.phone; }
}
