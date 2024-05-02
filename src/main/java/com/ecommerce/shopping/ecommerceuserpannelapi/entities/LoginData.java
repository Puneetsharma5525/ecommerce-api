package com.ecommerce.shopping.ecommerceuserpannelapi.entities;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
public class LoginData {
    @NotBlank(message = "Username is required!")
    @Size(min = 3, max = 12, message = "Username must be between 3 and 12 characters")
    private String username;

    @NotBlank(message = "Email is required!")
    @Email(message = "Please enter a valid email address")
    private String email;
}
