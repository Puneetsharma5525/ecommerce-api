package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProfileService {
   List<Profile> getProfile();
   Profile postProfile
           (Profile profile);
   Profile deleteProfile(Profile profile);

}
