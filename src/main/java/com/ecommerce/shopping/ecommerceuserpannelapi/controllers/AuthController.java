package com.ecommerce.shopping.ecommerceuserpannelapi.controllers;

import com.ecommerce.shopping.ecommerceuserpannelapi.Authentication.AuthServiceImpl;
import com.ecommerce.shopping.ecommerceuserpannelapi.Authentication.LoginRequest;
import com.ecommerce.shopping.ecommerceuserpannelapi.entities.UserEntities;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponseObject;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    @Autowired
    AuthServiceImpl authServiceImpl;

    @PostMapping("login")
    public ApiResponseObject login(@RequestBody LoginRequest loginRequest) {
        try {
            return authServiceImpl.login(loginRequest.getEmail(), loginRequest.getPassword());
        } catch (Exception e) {
            System.out.println("Error Sharma ji");
            return new ApiResponseObject<>(HttpStatus.BAD_REQUEST, e.toString(), "Invalid", null);
        }
    }


    @PostMapping("sign-up")
    public ApiResponseObject signUp(@Valid @RequestBody UserEntities userEntities, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ApiResponseObject<>(HttpStatus.BAD_REQUEST, "Validation error: " + bindingResult.getAllErrors(), "Invalid", null);
        }
        try {
            return authServiceImpl.signUp(userEntities.getUsername(), userEntities.getEmail(), userEntities.getPassWord(), userEntities.getMobile());

        } catch (Exception e) {
            System.out.println("Error Sharma  ji");
            return new ApiResponseObject<>(HttpStatus.BAD_REQUEST, e.toString(), "Invalid", null);

        }
    }

}
