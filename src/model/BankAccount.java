package model;

import exception.InsufficientFundException;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private final int accountNumber;
    protected String accountType;
    protected double balance;

    protected BankAccount() {
        this.accountNumber = generateAccountNumber();
        this.transactions = new ArrayList<>();
    }

    public abstract double getBalance();

    int generateAccountNumber() {
        return (1000000 + (int)(Math.random() * 9000000));
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    private List<Transaction> transactions;
    protected void addTransaction(String transactionType, double amount) {
        transactions.add(new Transaction(transactionType, amount));
    }

    public List<Transaction> printTransactionHistory() {
        return transactions;
    }

    public abstract void withdraw(double amount) throws InsufficientFundException;

    public abstract void deposit(double amount);


}
