package com.aryan.bankease.dto;

import jakarta.validation.constraints.Positive;

public class TransferRequestDTO {
    private Integer fromAccountId;
    private Integer toAccountId;

    @Positive(message = "Amount must be positive")
    private Double amount;

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
