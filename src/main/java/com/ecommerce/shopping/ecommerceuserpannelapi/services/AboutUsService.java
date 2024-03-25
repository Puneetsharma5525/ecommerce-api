package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.AboutUs;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AboutUsService {
     Optional<AboutUs> getAboutUs();
     void createAboutUs(String desc,String title);
     AboutUs updateAboutUs(AboutUs aboutUs);
     void deleteAboutUs();
}
