package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {

    @RequestMapping(value = {"", "/", "/index", "/home"})
    public String homePage(Model model) {
        model.addAttribute("mess", "Hello HomePage");
        return "index";
    }

    @GetMapping("/403")
    public String get403() {
        return "403";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/forget")
    public String forget() {
        return "forget";
    }
}
