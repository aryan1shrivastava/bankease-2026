package app;

import model.BankAccount;
import model.CurrentAccount;
import model.SavingsAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    static Optional<BankAccount> findAccountById(Map<Integer, BankAccount> accounts, int id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome to BankEase!");

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String type = "CURRENT";

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

            fetchedAccount.deposit(1000);
            fetchedAccount.withdraw(6000);

            System.out.println("Type: " + fetchedAccount.getAccountType());
            System.out.println("Balance: " + fetchedAccount.getBalance());
        }
        else{
            System.out.println("No account with account number " + account.getAccountNumber());
        }
    }
}