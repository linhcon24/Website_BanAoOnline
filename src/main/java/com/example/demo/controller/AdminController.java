package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String getAdmin() {
        return "adminDashboard";
    }

    @GetMapping("/tables")
    public String getTables() {
        return "admin/tables";
    }

    @GetMapping("/charts")
    public String getCharts() {
        return "admin/charts";
    }

    @GetMapping("/403")
    public String get403(){
        return "403";
    }

}
