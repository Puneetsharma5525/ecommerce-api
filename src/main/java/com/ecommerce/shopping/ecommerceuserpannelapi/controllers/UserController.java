package com.ecommerce.shopping.ecommerceuserpannelapi.controllers;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.UserEntities;
import com.ecommerce.shopping.ecommerceuserpannelapi.imples.UserImpl;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponseObject;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserImpl userService;
    @GetMapping("/user/{id}")
    public ApiResponseObject<UserEntities> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/user")
    public ApiResponseObject<List<UserEntities>> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/user")
    public ApiResponseObject<UserEntities> addUser(@Valid @RequestBody UserEntities userEntities, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessage.append(fieldError.getDefaultMessage()).append("; ");
            }
            return new ApiResponseObject<>(HttpStatus.BAD_REQUEST, errorMessage.toString(), "Invalid", null);
        }
        return userService.addUser(userEntities);
    }

    @DeleteMapping("/user/{id}")
    public ApiResponseObject<UserEntities> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
