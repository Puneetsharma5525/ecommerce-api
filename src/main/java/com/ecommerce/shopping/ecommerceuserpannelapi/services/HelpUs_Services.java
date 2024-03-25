package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.HelpUs;
import org.springframework.stereotype.Service;

@Service
public interface HelpUs_Services {
 HelpUs getHelUs();
 HelpUs postHelUs(HelpUs helpUs);

}
