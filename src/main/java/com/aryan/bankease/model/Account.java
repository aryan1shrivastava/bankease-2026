package com.aryan.bankease.model;

import com.aryan.bankease.exception.InsufficientFundException;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_type", insertable = false, updatable = false)
    private String accountType;

    private double balance;

    private LocalDateTime createdAt;

    protected Account() {
        this.createdAt = LocalDateTime.now();
    }

    // Abstract methods that child classes must implement
    public abstract void withdraw(double amount) throws InsufficientFundException;
    public abstract void deposit(double amount);

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}