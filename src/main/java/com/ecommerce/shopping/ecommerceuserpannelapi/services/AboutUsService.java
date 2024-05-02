package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.AboutUs;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AboutUsService {
     Optional<AboutUs> getAboutUs();
     ResponseEntity<ApiResponse> updateAboutUs(AboutUs aboutUs,  boolean create);
     ResponseEntity<ApiResponse>  deleteAboutUs();
}
