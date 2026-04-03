package app;

import model.CurrentAccount;
import model.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to BankEase!");

        SavingsAccount savingsAccount = new SavingsAccount();
        CurrentAccount currentAccount = new CurrentAccount();

        savingsAccount.deposit(500);
        currentAccount.deposit(5000);

        savingsAccount.withdraw(200);
        currentAccount.withdraw(60000);

        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Current Account Balance: " + currentAccount.getBalance());
    }
}