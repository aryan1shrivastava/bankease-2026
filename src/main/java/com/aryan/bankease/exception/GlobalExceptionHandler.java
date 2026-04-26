package com.aryan.bankease.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientFundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInsufficientFund(InsufficientFundException ex) {
        return ex.getMessage();
    }
}