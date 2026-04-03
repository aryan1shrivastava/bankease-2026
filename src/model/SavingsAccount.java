package model;

public class SavingsAccount extends BankAccount{

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void withdraw(double amount) {
        if(balance >= amount){
            balance -= amount;
        }
        else{
            System.out.println("Withdraw Failed, Insufficient Balance");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }
}
