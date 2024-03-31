//package com.ecommerce.shopping.ecommerceuserpannelapi.exception;
//
//import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(ResourceNotFoundExceptions.class)
//    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundExceptions ex) {
//        String message = ex.getMessage();
//        String title = ex.getResourceFieldName();
//        ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND, title, message);
//        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(HeaderNotFoundExceptions.class)
//    public ResponseEntity<ApiResponse> headerNotFoundExceptions(HeaderNotFoundExceptions ex) {
//        String message = ex.getMessage();
//        ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND, "title", message);
//        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
//    }
//
//}
