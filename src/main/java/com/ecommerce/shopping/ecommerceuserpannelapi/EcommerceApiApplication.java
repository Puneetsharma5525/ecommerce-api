package com.ecommerce.shopping.ecommerceuserpannelapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import com.ecommerce.shopping.ecommerceuserpannelapi.controllers.ThymeleafController; 

@SpringBootApplication
public class EcommerceApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApiApplication.class, args);
    
    
    }

}
