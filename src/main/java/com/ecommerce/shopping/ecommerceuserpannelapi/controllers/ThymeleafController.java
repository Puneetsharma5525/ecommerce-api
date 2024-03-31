package com.ecommerce.shopping.ecommerceuserpannelapi.controllers;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.LoginData;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class ThymeleafController implements ErrorController {
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(@NotNull Model model) {
        // putting data in model
        model.addAttribute("name", "Puneet Sharma");
        model.addAttribute("currentDate ", new Date().toString());
        System.out.println("inside about handler ......");
        return "about";
    }

    @GetMapping("/iterate")
    public String iterateHandler(Model model) {
        List<String> list = List.of("Ankit", "Laxmi", "Karan", "John");
        model.addAttribute("name", list);
        return "iterate";
    }

    @GetMapping("/condition")
    public String conditionHandler(Model model) {
        model.addAttribute("isActive", true);
        model.addAttribute("showBox", false);
        List<Integer> list = List.of(0, 1, 2, 3, 4, 5, 6, 7);
        model.addAttribute("myList", list);
        return "condition";
    }

    @GetMapping("/services")
    public String servicesHandler(Model m) {
        m.addAttribute("firstName", "Puneet");
        m.addAttribute("lastName", "Sharma");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        m.addAttribute("dateTime", dtf.format(now));
        return "services";
    }

    @RequestMapping(value = "/contactUs", method = RequestMethod.GET)
    public String contactUs(@NotNull Model model) {
        // putting data in model
        model.addAttribute("metaDescription", " Assuming contact is the name of your Thymeleaf template file");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("currentDate ", dtf.format(now));
        System.out.println("inside about handler ......");
        return "contact";
    }

    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String loginForm(Model model) {
        System.out.println("Opening login form");
        model.addAttribute("loginData", new LoginData());
        return "loginForm";
    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result) {
        if (!result.hasErrors()) {
            System.out.println("Login data is valid:");
            return "success";
        }
        System.out.println("Validation errors occurred:");
        return "loginForm";
    }


    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }
}
