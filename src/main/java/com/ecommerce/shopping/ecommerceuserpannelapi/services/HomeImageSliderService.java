package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.HomeImageSlider;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HomeImageSliderService{
    List<HomeImageSlider> getImageSlider();
    HomeImageSlider postImageSlider(HomeImageSlider homeImageSlider);
}
