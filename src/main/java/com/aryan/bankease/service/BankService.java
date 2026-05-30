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

    //Create new savings or current account
    public BankAccount createAccount(String type) {
        if(type == null || (!type.equalsIgnoreCase("SAVINGS") && !type.equalsIgnoreCase("CURRENT"))){
            throw new IllegalArgumentException("Invalid account type. MUST be SAVINGS or CURRENT");
        }

        BankAccount account = type.equalsIgnoreCase("SAVINGS")
                ? new SavingsAccount()
                : new CurrentAccount();

        accounts.put(account.getAccountNumber(),  account);
        return account;
    }

    public Optional<BankAccount> getAccount(int accountId) {
        return Optional.ofNullable(accounts.get(accountId));
    }

    //Deposit money into account
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
