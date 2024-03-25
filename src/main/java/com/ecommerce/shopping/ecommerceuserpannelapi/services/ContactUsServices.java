package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.ContactUs;
import org.springframework.stereotype.Service;

@Service
public interface ContactUsServices {
    ContactUs postContactUs(ContactUs contactUs);
}
