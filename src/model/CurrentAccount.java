package model;

public class CurrentAccount extends BankAccount {
    @Override
    public double withdraw(double amount) {
        if(balance - amount >= -50000) {
            balance -= amount;
        }
        return balance;
    }

    @Override
    public double deposit(double amount) {
        balance += amount;
        return balance;
    }
}
