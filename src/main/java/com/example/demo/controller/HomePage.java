package com.example.demo.controller;

<<<<<<< HEAD
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
=======
import com.example.demo.bean.ForgetForm;
import com.example.demo.bean.LoginForm;
import com.example.demo.bean.RegisterForm;
>>>>>>> 38bbd63f98b021880d3aa875affc5ca4238be7c9
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePage {

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
