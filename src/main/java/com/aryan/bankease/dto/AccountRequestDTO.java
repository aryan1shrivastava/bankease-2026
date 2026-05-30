package com.aryan.bankease.dto;

import jakarta.validation.constraints.NotBlank;

public class AccountRequestDTO {
    @NotBlank(message = "Account type is required")
    private String accountType;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
