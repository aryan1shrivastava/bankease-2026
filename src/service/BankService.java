package service;

import exception.InsufficientFundException;
import model.BankAccount;
import model.CurrentAccount;
import model.SavingsAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class BankService {
    private Map<Integer, BankAccount> accounts = new HashMap<>();

    public BankAccount createAccount(String type) {
        BankAccount account;

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
        }else{
            throw new IllegalStateException("Account doesn't exist");
        }
    }
    public void withdraw(int accountId, double amount) throws InsufficientFundException {
        Optional<BankAccount> acc = getAccount(accountId);
        if(acc.isPresent()) {
            acc.get().withdraw(amount);
        }else{
            throw new IllegalStateException("Account doesn't exist");
        }
    }
}
