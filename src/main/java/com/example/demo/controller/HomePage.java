package com.example.demo.controller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.example.demo.bean.ForgetForm;
import com.example.demo.bean.LoginForm;
import com.example.demo.bean.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class HomePage {

    @Autowired
    HttpSession session;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    private Page<ChiTietSanPham> listChiTietSanPham;

    @RequestMapping(value = {"", "/", "/index", "/home"})
    public String homePage(Model model) {
        model.addAttribute("mess", "Hello Ha");
        return "homePage";
    }

    @GetMapping("/403")
    public String get403() {
        return "403";
    }

    @GetMapping("/logout")
    public String showLogout(Model model, RedirectAttributes attributes) {
//		session.removeAttribute("account");
        session.invalidate();
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("data" , new LoginForm());
        return "loginPage";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("data" , new RegisterForm());
        return "registerPage";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contactPage";
    }

    @GetMapping("/forget")
    public String forget(Model model) {
        model.addAttribute("data" , new ForgetForm());
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
    public String product(Model model,@RequestParam(defaultValue = "0",name = "num")Integer num) {
        listChiTietSanPham = chiTietSanPhamService.getAll(num,4);
        model.addAttribute("list",listChiTietSanPham);
        return "productPage";
    }
}
