package com.aryan.bankease.controller;

import com.aryan.bankease.model.ApiResponse;
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
    public ApiResponse<BankAccount> createAccount(@RequestParam String type){
        BankAccount account = service.createAccount(type.toUpperCase());
        return new ApiResponse<>("SUCCESS", "Account created successfully", account);
    }

    @PostMapping("/deposit")
    public ApiResponse<String> deposit(@RequestParam int id, @RequestParam double amount){
        service.deposit(id, amount);
        return new ApiResponse<>("SUCCESS", "Deposit Successful", null);
    }

    @PostMapping("/withdraw")
    public ApiResponse<String> withdraw(@RequestParam int id, @RequestParam double amount){
        service.withdraw(id, amount);
        return new ApiResponse<>("SUCCESS", "Withdrawal Successful", null);
    }

}
