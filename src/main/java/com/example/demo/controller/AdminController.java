package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String getAdmin() {
        return "admin/dashboard";
    }
    @GetMapping("/tables")
    public String getTables() {
        return "admin/tables";
    }
    @GetMapping("/charts")
    public String getCharts() {
        return "admin/charts";
    }
}
