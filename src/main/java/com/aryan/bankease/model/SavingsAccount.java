package com.aryan.bankease.model;

import com.aryan.bankease.exception.InsufficientFundException;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SAVINGS")
public class SavingsAccount extends Account {

    public SavingsAccount() {
        setAccountType("SAVINGS");
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
        } else {
            throw new InsufficientFundException("Insufficient funds! Your balance is: " + getBalance());
        }
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }
}