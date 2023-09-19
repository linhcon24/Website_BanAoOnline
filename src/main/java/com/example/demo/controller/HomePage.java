package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePage {

    @RequestMapping(value = {"" , "/" ,"/index" , "/home"})
    public String homePage(Model model){
        model.addAttribute("mess" , "Hello HomePage");
        return"index";
    }
}
