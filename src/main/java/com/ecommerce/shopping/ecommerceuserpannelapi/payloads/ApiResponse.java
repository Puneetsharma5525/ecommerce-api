package com.ecommerce.shopping.ecommerceuserpannelapi.payloads;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ApiResponse {
   private HttpStatus err_code;
    private String status;
    private String message;
}
