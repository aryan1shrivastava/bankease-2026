package com.aryan.bankease.service;

import com.aryan.bankease.exception.InsufficientFundException;
import com.aryan.bankease.model.BankAccount;
import com.aryan.bankease.model.CurrentAccount;
import com.aryan.bankease.model.SavingsAccount;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BankService {
    private Map<Integer, BankAccount> accounts = new HashMap<>();

    public BankAccount createAccount(String type) {
        BankAccount account;

        if (!type.equals("SAVINGS") && !type.equals("CURRENT")) {
            throw new IllegalArgumentException("Invalid account type");
        }

        switch (type) {
            case "SAVINGS" -> account = new SavingsAccount();
            case "CURRENT" -> account = new CurrentAccount();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        accounts.put(account.getAccountNumber(), account);
        return account;
    }

    public Optional<BankAccount> getAccount(int accountId) {
        return Optional.ofNullable(accounts.get(accountId));
    }

    public void deposit(int accountId, double amount) {
        Optional<BankAccount> acc = getAccount(accountId);

        if(acc.isPresent()) {
            acc.get().deposit(amount);
            if(amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0");
            }
        }else{
            throw new IllegalStateException("Account doesn't exist");
        }
    }
    public void withdraw(int accountId, double amount) throws InsufficientFundException {
        Optional<BankAccount> acc = getAccount(accountId);
        if(acc.isPresent()) {
            acc.get().withdraw(amount);
            if(amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0");
            }
        }else{
            throw new IllegalStateException("Account doesn't exist");
        }
    }
}
