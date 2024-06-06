package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponseObject;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    ApiResponseObject login(String emailAndMobile, String password);

    ApiResponseObject signUp(String userName, String password,@Nullable  String mobile,@Nullable  String email) ;
}
