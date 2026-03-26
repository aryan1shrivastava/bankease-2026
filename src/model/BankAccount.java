package model;

public abstract class BankAccount {
    String accountNumber;
    String accountType;
    double balance;

    public double getBalance() {
        return balance;
    }

    public abstract double withdraw(double amount);

    public abstract double deposit(double amount);

}
