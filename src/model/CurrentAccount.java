package model;

import exception.InsufficientFundException;

public class CurrentAccount extends BankAccount {
    public CurrentAccount() {
        this.accountType = "CURRENT";
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException {
        if(balance - amount >= -50000) {
            balance -= amount;
            addTransaction("WITHDRAW", amount);
        }
        else {
            throw new InsufficientFundException("Insufficient funds! Your balance is: " + balance);
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("DEPOSIT", amount);
    }
}
