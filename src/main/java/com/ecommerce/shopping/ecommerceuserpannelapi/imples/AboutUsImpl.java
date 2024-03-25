package com.ecommerce.shopping.ecommerceuserpannelapi.imples;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.AboutUs;
import com.ecommerce.shopping.ecommerceuserpannelapi.repositories.AboutUsDao;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.AboutUsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AboutUsImpl implements AboutUsService {
    @Autowired
    AboutUsDao aboutUsDao;
    @Override
    public Optional<AboutUs> getAboutUs() {
        return aboutUsDao.findFirstAboutUs();
    }


    @Override
    public void createAboutUs(String desc,String title) {
        AboutUs aboutUs = new AboutUs();
        aboutUs.setDesc(desc);
        aboutUs.setTitle(title);

        aboutUsDao.insertAboutUs(desc,title);
    }

    @Override
    public AboutUs updateAboutUs(AboutUs aboutUs) {
        return aboutUsDao.save(aboutUs);

    }



    @Override
    public void deleteAboutUs() {
        aboutUsDao.deleteAll();
    }
}
