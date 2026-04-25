package model;

public class SavingsAccount extends BankAccount{

    public SavingsAccount() {
        this.accountType = "SAVINGS";
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void withdraw(double amount) {
        if(balance >= amount){
            balance -= amount;
            addTransaction("WITHDRAW", amount);
        }
        else{
            System.out.println("Withdraw Failed, Insufficient Balance");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("DEPOSIT", amount);
    }
}
