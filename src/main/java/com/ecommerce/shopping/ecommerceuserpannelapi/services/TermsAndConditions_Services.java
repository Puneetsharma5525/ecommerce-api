package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.TermsAndConditions;
import org.springframework.stereotype.Service;

@Service
public interface TermsAndConditions_Services {
    TermsAndConditions getTermsAndConditions();
    TermsAndConditions postTermsAndConditions(TermsAndConditions termsAndConditions);

}
