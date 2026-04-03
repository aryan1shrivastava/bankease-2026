package model;

public abstract class BankAccount {
    private int accountNumber;
    private String accountType;
    protected double balance;

    protected BankAccount() {
        this.accountNumber = generateAccountNumber();
    }

    public abstract double getBalance();

    int generateAccountNumber() {
        return (1000000 + (int)(Math.random() * 9000000));
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

}
