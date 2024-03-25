package com.ecommerce.shopping.ecommerceuserpannelapi.imples;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.HomeImageSlider;
import com.ecommerce.shopping.ecommerceuserpannelapi.repositories.HomeImageSliderDao;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.HomeImageSliderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeImageSliderImpl implements HomeImageSliderService {
    @Autowired
    HomeImageSliderDao homeImageSliderDao;
    @Override
    public List<HomeImageSlider> getImageSlider() {
        return homeImageSliderDao.findAll();
    }
    @Override
    public HomeImageSlider postImageSlider(HomeImageSlider homeImageSlider) {
        homeImageSliderDao.save(homeImageSlider);
        return homeImageSlider;
    }
}
