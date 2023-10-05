package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    HttpSession session;

//    @GetMapping("/logout")
//    public String showLogout(Model model, RedirectAttributes attributes) {
////		session.removeAttribute("account");
//        session.invalidate();
//        return "redirect:/index";
//    }


    @GetMapping("/dashboard")
    public String getAdmin() {
        return "adminDashboard";
    }

    @GetMapping("/tables")
    public String getTables() {
        return "tablePage";
    }

    @GetMapping("/charts")
    public String getCharts() {
        return "chartPage";
    }

    @GetMapping("/403")
    public String get403(){
        return "403";
    }


}
