package com.ecommerce.shopping.ecommerceuserpannelapi.payloads;
import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ApiResponseObject<T> {
    private HttpStatus err_code;
    private String message;
    private String status;
    private T data;
    public ApiResponseObject(HttpStatus errCode, String message, String status, T data) {
        this.err_code = errCode;
        this.message = message;
        this.status = status;
        if (data != null) {
            this.data = data;
        }
    }
}
