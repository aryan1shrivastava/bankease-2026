package com.aryan.bankease.model;

import com.aryan.bankease.exception.InsufficientFundException;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CURRENT")
public class CurrentAccount extends Account {

    public CurrentAccount() {
        setAccountType("CURRENT");
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException {
        if (getBalance() - amount >= -50000) {
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