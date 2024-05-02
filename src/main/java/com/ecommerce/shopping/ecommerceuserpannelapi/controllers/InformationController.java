package com.ecommerce.shopping.ecommerceuserpannelapi.controllers;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.AboutUs;
import com.ecommerce.shopping.ecommerceuserpannelapi.imples.AboutUsImpl;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class InformationController {

    @Autowired
    public AboutUsImpl aboutUs;
    @GetMapping("/AboutUs")
    public Optional<AboutUs> getAboutUs() {
        return aboutUs.getAboutUs();
    }

    @PostMapping("/AboutUs")
    public ResponseEntity<ApiResponse> createAboutUs(@RequestBody AboutUs aboutUs) {
        return  this.aboutUs.updateAboutUs(aboutUs,true);
    }

    @PutMapping("/AboutUs")
    public ResponseEntity<ApiResponse> updateAboutUs(@RequestBody AboutUs aboutUs) {
        return  this.aboutUs.updateAboutUs(aboutUs,false);
    }

    @DeleteMapping("/AboutUs")
    public ResponseEntity<ApiResponse> deleteAboutUs() {
       return this.aboutUs.deleteAboutUs();
    }
}
