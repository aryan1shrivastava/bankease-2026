package com.aryan.bankease.controller;

import com.aryan.bankease.dto.AccountRequestDTO;
import com.aryan.bankease.dto.TransferRequestDTO;
import com.aryan.bankease.model.ApiResponse;
import com.aryan.bankease.model.BankAccount;
import com.aryan.bankease.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")   // Changed to /api/bank for better REST practice
public class BankController {

    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<BankAccount> createAccount(@RequestBody AccountRequestDTO request) {
        BankAccount account = service.createAccount(request.getAccountType().toUpperCase());
        return new ApiResponse<>("SUCCESS", "Account created successfully", account);
    }

    @PostMapping("/deposit")
    public ApiResponse<String> deposit(@RequestBody TransferRequestDTO request) {
        service.deposit(request.getFromAccountId(), request.getAmount());
        return new ApiResponse<>("SUCCESS", "Deposit Successful", null);
    }

    @PostMapping("/withdraw")
    public ApiResponse<String> withdraw(@RequestBody TransferRequestDTO request) {
        service.withdraw(request.getFromAccountId(), request.getAmount());
        return new ApiResponse<>("SUCCESS", "Withdrawal Successful", null);
    }
}