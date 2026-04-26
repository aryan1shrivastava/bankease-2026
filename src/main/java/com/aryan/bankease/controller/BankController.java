package com.aryan.bankease.controller;

import com.aryan.bankease.exception.InsufficientFundException;
import com.aryan.bankease.model.BankAccount;
import com.aryan.bankease.service.BankService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {
    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public BankAccount createAccount(@RequestParam String type) {
        return service.createAccount(type);
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam int id, @RequestParam double amount) {
        service.deposit(id, amount);
        return "Deposit successful";
    }

    @PostMapping("withdraw")
    public String withdraw(@RequestParam int id, @RequestParam double amount) throws InsufficientFundException {
        service.withdraw(id, amount);
        return "Withdraw successful";
    }
}
