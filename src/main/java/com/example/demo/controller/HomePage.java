package com.example.demo.controller;

import com.example.demo.bean.ChangeForm;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.GioHangChiTietService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.example.demo.bean.ForgetForm;
import com.example.demo.bean.LoginForm;
import com.example.demo.bean.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomePage {

    @Autowired
    HttpSession session;

    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    private Page<ChiTietSanPham> listChiTietSanPham;
    private Page<SanPham> listSanPham;
    private Page<GioHangChiTiet> listGioHangChiTiet;

    @RequestMapping(value = {"", "/", "/index", "/home"})
    public String homePage(Model model) {
        return "homePage";
    }

    @GetMapping("/info")
    public String info() {
        return "about";
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

    @PostMapping("/login")
    public String login(Model model, RedirectAttributes redirect, @ModelAttribute("data") LoginForm form,
                        BindingResult result) {
        String username = form.getUsername();
        String password = form.getPassword();
        if (!result.hasErrors()) {
            TaiKhoan account = taiKhoanService.getByUsername(username);
            if (account == null) {
                System.out.println("false");
                return "redirect:/login";
            }
            if (account.getPassword().equals(password)) {
                session.setAttribute("account", account);
                System.out.println("oke");
                redirect.addFlashAttribute("message" , "Đăng nhập thành công!");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/index";
            }
            model.addAttribute("message", "Username or Password incorrect !");
            model.addAttribute("type", "error");
            return "loginPage";
        }
        return "loginPage";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("data" , new RegisterForm());
        return "registerPage";
    }

    @PostMapping("/register")
    public String addRegister(Model model, RedirectAttributes redirect,
                               @ModelAttribute("data") RegisterForm form, BindingResult result, HttpServletRequest request) {
        String username = form.getUsername();
        String password = form.getPassword();
        String repassword = form.getRePassword();
        String email = form.getEmail();
        if (result.hasErrors()) {
            return "registerPage";
        }
        if (!result.hasErrors()) {
            if (taiKhoanService.getByUsername(form.getUsername()) != null) {
                request.setAttribute("message", "Username đã tồn tại trên hệ thống !");
                request.setAttribute("type", "error");
                return "registerPage";
            }
            if (!password.equals(repassword)) {
                request.setAttribute("message", "Pass và Repass chưa khớp !");
                request.setAttribute("type", "error");
                return "registerPage";
            }
            if (request.getParameter("checkbox") == null) {
                request.setAttribute("message", "Vui lòng đồng ý với điều khoản trước khi đăng ký !");
                request.setAttribute("type", "error");
                return "registerPage";
            }

            TaiKhoan account = new TaiKhoan();
            account.setUsername(username);
            account.setPassword(password);
            account.setEmail(email);
            account.setVaitro(1);
            account.setTrangthai(0);

            if (taiKhoanService.add(account) != null) {

                redirect.addFlashAttribute("message" , "Đăng ký thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/register";
            }

        }
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
    public String change(Model model) {
        model.addAttribute("data" , new ChangeForm());
        return "changePage";
    }

    @GetMapping("/cart")
    public String cart(Model model,@RequestParam(defaultValue = "0",name = "num")Integer num){
        TaiKhoan tk = (TaiKhoan) session.getAttribute("account");
        listGioHangChiTiet = gioHangChiTietService.getAll(num, 4, tk.getIdtaikhoan());
        Double totalMoney = gioHangChiTietService.getTotalMoney(gioHangChiTietService.count(tk.getIdtaikhoan()));
        Integer totalProduct = gioHangChiTietService.getTotalProduct(gioHangChiTietService.count(tk.getIdtaikhoan()));
        model.addAttribute("totalMoney",totalMoney);
        model.addAttribute("totalProduct",totalProduct);
        model.addAttribute("listGioHangChiTiet",listGioHangChiTiet);
        return "cartPage";
    }


    @GetMapping("/product")
    public String product(Model model,@RequestParam(defaultValue = "0",name = "num")Integer num) {
        listSanPham = sanPhamService.getAll(num,4);
        model.addAttribute("list",listSanPham);
        return "productPage";
    }
}
