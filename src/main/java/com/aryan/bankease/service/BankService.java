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

    private final Map<Integer, BankAccount> accounts = new HashMap<>();

    public BankAccount createAccount(String type) {
        if (type == null || (!type.equalsIgnoreCase("SAVINGS") && !type.equalsIgnoreCase("CURRENT"))) {
            throw new IllegalArgumentException("Invalid account type. Must be SAVINGS or CURRENT");
        }

        BankAccount account = type.equalsIgnoreCase("SAVINGS")
                ? new SavingsAccount()
                : new CurrentAccount();

        accounts.put(account.getAccountNumber(), account);
        return account;
    }

    public Optional<BankAccount> getAccount(int accountId) {
        return Optional.ofNullable(accounts.get(accountId));
    }

    public void deposit(int accountId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }

        BankAccount account = getAccount(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + accountId));

        account.deposit(amount);
    }

    public void withdraw(int accountId, double amount) throws InsufficientFundException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than 0");
        }

        BankAccount account = getAccount(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + accountId));

        account.withdraw(amount);
    }
}