package com.ecommerce.shopping.ecommerceuserpannelapi.imples;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.Profile;
import com.ecommerce.shopping.ecommerceuserpannelapi.repositories.ProfileDao;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class profileServiceImpl implements ProfileService {
    @Autowired
    ProfileDao profileDao;

    @Override
    public List<Profile> getProfile() {
        return profileDao.findAll();
    }

    @Override
    public Profile postProfile(Profile aboutUs) {
        profileDao.save(aboutUs);
        return aboutUs;
    }

    @Override

    public Profile deleteProfile(Profile profile) {
        // profile.
        return null;
    }
}
