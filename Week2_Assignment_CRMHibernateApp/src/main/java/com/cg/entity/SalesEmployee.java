package com.cg.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class SalesEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    @OneToMany(mappedBy = "employee",
               cascade = CascadeType.ALL)
    private List<Lead> leads;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }
}