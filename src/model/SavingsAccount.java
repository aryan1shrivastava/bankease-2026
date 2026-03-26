package model;

public class SavingsAccount extends BankAccount{

    @Override
    public double withdraw(double amount) {
        if(balance >= amount){
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
