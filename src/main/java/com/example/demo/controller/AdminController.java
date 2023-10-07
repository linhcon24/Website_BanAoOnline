package com.example.demo.controller;

import com.example.demo.bean.RegisterForm;
import com.example.demo.bean.TaiKhoanForm;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    HttpSession session;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/logout")
    public String showLogout(Model model, RedirectAttributes redirect) {
//		session.removeAttribute("account");
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping()
    public String register(Model model, @PathVariable(value = "id") Integer id) {
        TaiKhoan taiKhoan = taiKhoanService.getAccountById(id);
        model.addAttribute("account", taiKhoan);
        model.addAttribute("data" , new TaiKhoanForm());
        return "adminDashboard";
    }



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
