package com.aryan.bankease.service;

import com.aryan.bankease.exception.InsufficientFundException;
import com.aryan.bankease.model.Account;
import com.aryan.bankease.model.CurrentAccount;
import com.aryan.bankease.model.SavingsAccount;
import com.aryan.bankease.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    private final AccountRepository accountRepository;

    public BankService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String type) {
        if (type == null || (!type.equalsIgnoreCase("SAVINGS") && !type.equalsIgnoreCase("CURRENT"))) {
            throw new IllegalArgumentException("Invalid account type. Must be SAVINGS or CURRENT");
        }

        Account account = type.equalsIgnoreCase("SAVINGS")
                ? new SavingsAccount()
                : new CurrentAccount();

        return accountRepository.save(account);   // Save to database
    }

    public Optional<Account> getAccount(int accountId) {
        return accountRepository.findById(accountId);
    }

    public void deposit(int accountId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }

        Account account = getAccount(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + accountId));

        account.deposit(amount);
        accountRepository.save(account);   // Save updated balance
    }

    public void withdraw(int accountId, double amount) throws InsufficientFundException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than 0");
        }

        Account account = getAccount(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + accountId));

        account.withdraw(amount);
        accountRepository.save(account);   // Save updated balance
    }
}