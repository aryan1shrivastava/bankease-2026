package com.aryan.bankease.exception;

import com.aryan.bankease.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(InsufficientFundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<String> handleInsufficientFund(InsufficientFundException ex) {

        return new ApiResponse<>("FAILED", ex.getMessage(), null);
    }
}