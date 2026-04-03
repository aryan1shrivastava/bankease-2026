package model;

public abstract class BankAccount {
    private final int accountNumber;
    protected String accountType;
    protected double balance;

    protected BankAccount() {
        this.accountNumber = generateAccountNumber();
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

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

}
