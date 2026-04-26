package app;

import exception.InsufficientFundException;
import model.BankAccount;
import service.BankService;

import java.util.*;

public class Main {

    public static void main(String[] args){
        System.out.println("Hello and welcome to BankEase!");
        BankService service = new BankService();

        BankAccount acc = service.createAccount("SAVINGS");
        int id = acc.getAccountNumber();

        try {
            service.deposit(id, 10000);
            service.withdraw(id, 6000);
            service.withdraw(id, 10000); // will throw
        } catch (InsufficientFundException e) {
            System.out.println(e.getMessage());
        }

    }
}