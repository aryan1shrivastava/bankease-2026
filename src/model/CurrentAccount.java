package model;

public class CurrentAccount extends BankAccount {
    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void withdraw(double amount) {
        if(balance - amount >= -50000) {
            balance -= amount;
        }
        else {
            System.out.println("Withdraw Failed, max overdraft limit reached");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }
}
