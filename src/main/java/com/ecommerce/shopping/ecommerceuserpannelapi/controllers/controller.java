package com.ecommerce.shopping.ecommerceuserpannelapi.controllers;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.AboutUs;
import com.ecommerce.shopping.ecommerceuserpannelapi.entities.HomeImageSlider;
import com.ecommerce.shopping.ecommerceuserpannelapi.entities.ProductCategory;
import com.ecommerce.shopping.ecommerceuserpannelapi.entities.Profile;
import com.ecommerce.shopping.ecommerceuserpannelapi.exception.HeaderNotFoundExceptions;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponse;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.AboutUsService;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.HomeImageSliderService;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.ProductCategoryServices;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class controller {
    @Autowired
    public ProfileService profileService;
    @Autowired
    public HomeImageSliderService homeImageSliderService;
    @Autowired
    public ProductCategoryServices productCategoryServices;
    @Autowired
    public AboutUsService aboutUsService;

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

    @PostMapping(path = "/HomeImageSlider")
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

    @GetMapping("/AboutUs")
    public Optional<AboutUs> getProductAboutUs() {
        return aboutUsService.getAboutUs();
    }

    @PostMapping("/AboutUs")
    public ResponseEntity<ApiResponse> addProductCategory(@RequestParam String desc, @RequestParam String title) {
        if (desc == null || title == null) {
            throw new HeaderNotFoundExceptions("aboutUs");
        }
        this.aboutUsService.createAboutUs(desc, title);

        ApiResponse response = new ApiResponse(HttpStatus.OK, "Success", "Address added successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/AboutUs")
    public ResponseEntity<ApiResponse> updateProductCategory(@RequestBody AboutUs aboutUs) {

        if (aboutUs == null) {
            throw new HeaderNotFoundExceptions("aboutUs");
        }
        this.aboutUsService.updateAboutUs(aboutUs);
        ApiResponse response = new ApiResponse(HttpStatus.FOUND, "Success", "About Us successfully Updated");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/AboutUs")
    public ResponseEntity<ApiResponse> deleteProductCategory() {
        aboutUsService.deleteAboutUs();
        ApiResponse response = new ApiResponse(HttpStatus.FOUND, "Success", "About Us successfully Delete");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){
        String text = "this is private page";
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


