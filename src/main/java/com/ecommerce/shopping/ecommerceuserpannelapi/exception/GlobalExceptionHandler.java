package com.ecommerce.shopping.ecommerceuserpannelapi.exception;


import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponse;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleMissingRequestBody(HttpMessageNotReadableException ex) {
        ApiResponse response = new ApiResponse(HttpStatus.BAD_REQUEST, "Invalid", "Required request body is missing");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseObject<?>> handleException(Exception ex) {
        String errorMessage = ex.getMessage() != null ? ex.getMessage() : "Unknown error occurred";
        ApiResponseObject<?> response = new ApiResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, "Invalid", null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiResponseObject<?>> handleSqlIntegrityConstraintViolation(SQLIntegrityConstraintViolationException ex) {
        if (ex.getMessage().contains("Duplicate entry")) {
            String errorMessage = "Email already exists. Please choose a different email.";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponseObject<>(HttpStatus.CONFLICT, errorMessage, "Invalid", null));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", "Error", null));
        }
    }

}
