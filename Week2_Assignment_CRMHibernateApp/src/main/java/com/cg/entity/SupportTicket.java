package com.cg.entity;

import jakarta.persistence.*;

@Entity
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueDescription;

    @OneToOne
    @JoinColumn(name="order_id")
    private Order order;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}