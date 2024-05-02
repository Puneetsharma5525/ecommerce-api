package com.ecommerce.shopping.ecommerceuserpannelapi.controllers;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.HomeImageSlider;
import com.ecommerce.shopping.ecommerceuserpannelapi.entities.ProductCategory;
import com.ecommerce.shopping.ecommerceuserpannelapi.entities.Profile;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.HomeImageSliderService;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.ProductCategoryServices;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class controller {
    @Autowired
    public ProfileService profileService;
    @Autowired
    public HomeImageSliderService homeImageSliderService;
    @Autowired
    public ProductCategoryServices productCategoryServices;

    @GetMapping("/Profile")
    public List<Profile> getProfileData() {
        return profileService.getProfile();
    }

    @PostMapping(path = "/Profile")
    public Profile addProfile(@RequestBody Profile profile) {
        return this.profileService.postProfile(profile);
    }

    @GetMapping("/HomeImageSlider")
    public List<HomeImageSlider> getHomeImageSlider() {
        return homeImageSliderService.getImageSlider();
    }

    @PostMapping(path = "/ImageSlider")
    public HomeImageSlider addHomeImageSlider(@RequestBody HomeImageSlider homeImageSlider) {
        return this.homeImageSliderService.postImageSlider(homeImageSlider);
    }

    @GetMapping("/ProductCategory")
    public List<ProductCategory> getProductCategory() {
        return productCategoryServices.productCategory();
    }

    @PostMapping(path = "/ProductCategory")
    public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory) {
        return this.productCategoryServices.postProductCategory(productCategory);
    }



    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){
        String text = "this is private page ";
        text+="this page is not allowed to unauthenticated users";
        return  text;
    }
    @RequestMapping(value = "/go",method = RequestMethod.GET)
    public String go(){
        String text = "this is private page";
        text+="this page is not allowed to unauthenticated users";
        return  text;
    }
    
}


