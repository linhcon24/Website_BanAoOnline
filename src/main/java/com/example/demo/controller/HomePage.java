package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {

    @RequestMapping(value = {"", "/", "/index", "/home"})
    public String homePage(Model model) {
        model.addAttribute("mess", "Hello Ha");
        return "homePage";
    }

    @GetMapping("/403")
    public String get403() {
        return "403";
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/register")
    public String register() {
        return "registerPage";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contactPage";
    }

    @GetMapping("/forget")
    public String forget() {
        return "forgetPage";
    }

    @GetMapping("/change")
    public String change() {
        return "changePage";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cartPage";
    }

    @GetMapping("/product")
    public String product() {
        return "productPage";
    }
}
