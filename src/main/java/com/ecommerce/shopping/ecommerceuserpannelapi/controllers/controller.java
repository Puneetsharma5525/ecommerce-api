package com.ecommerce.shopping.ecommerceuserpannelapi.controllers;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.HomeImageSlider;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.HomeImageSliderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class controller {
    @Autowired
    public HomeImageSliderService homeImageSliderService;

    @GetMapping("/HomeImageSlider")
    public List<HomeImageSlider> getHomeImageSlider() {
        return homeImageSliderService.getImageSlider();
    }

    @PostMapping(path = "/ImageSlider")
    public HomeImageSlider addHomeImageSlider(@RequestBody HomeImageSlider homeImageSlider) {
        return this.homeImageSliderService.postImageSlider(homeImageSlider);
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


