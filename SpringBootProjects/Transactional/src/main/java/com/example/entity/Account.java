package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerName;
    private Double balance;

    public Account() {}
    public Account(String ownerName, Double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public Long getId() { return id; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
}