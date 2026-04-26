package app;

import exception.InsufficientFundException;
import model.BankAccount;
import model.CurrentAccount;
import model.SavingsAccount;
import model.Transaction;

import java.util.*;

public class Main {

    static Optional<BankAccount> findAccountById(Map<Integer, BankAccount> accounts, int id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public static void main(String[] args) throws InsufficientFundException {
        System.out.println("Hello and welcome to BankEase!");

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String type = "SAVINGS";

        BankAccount account;

        switch (type) {
            case "SAVINGS" -> account = new SavingsAccount();
            case "CURRENT" -> account = new CurrentAccount();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        accounts.put(account.getAccountNumber(), account);

        Optional<BankAccount> accountOptional = findAccountById(accounts, account.getAccountNumber());

        if (accountOptional.isPresent()) {
            BankAccount fetchedAccount = accountOptional.get();

            try {
                fetchedAccount.deposit(10000);
                fetchedAccount.withdraw(6000);
                fetchedAccount.withdraw(100000);
                fetchedAccount.deposit(5600);
            } catch (InsufficientFundException e) {
                System.out.println("Error: " + e.getMessage());
            }


            System.out.println("Type: " + fetchedAccount.getAccountType());
            System.out.println("Balance: " + fetchedAccount.getBalance());

            List<Transaction> history = fetchedAccount.printTransactionHistory();

            for( Transaction t : history) {
                System.out.println(t);
            }
        }
        else{
            System.out.println("No account with account number " + account.getAccountNumber());
        }


    }
}