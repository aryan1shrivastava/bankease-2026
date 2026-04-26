package model;

import exception.InsufficientFundException;

public class SavingsAccount extends BankAccount{

    public SavingsAccount() {
        this.accountType = "SAVINGS";
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundException {
        if(balance >= amount){
            balance -= amount;
            addTransaction("WITHDRAW", amount);
        }
        else{
            throw new InsufficientFundException("Insufficient funds! Your balance is: " + balance);
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("DEPOSIT", amount);
    }
}
