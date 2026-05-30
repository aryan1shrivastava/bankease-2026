package com.aryan.bankease.dto;

import jakarta.validation.constraints.Positive;

public class TransactionResponseDTO {
    private String message;
    private Double newBalance;
    private String status;

    public String getStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }

    public Double getNewBalance(){
        return newBalance;
    }
}

