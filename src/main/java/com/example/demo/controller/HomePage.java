package com.example.demo.controller;

import com.example.demo.bean.*;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.GioHangChiTietService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class HomePage {


    @Value("${upload.path}")
    private String pathFolder;

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
    public String login(Model model, RedirectAttributes redirect,@Valid @ModelAttribute("data") LoginForm form,
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
            model.addAttribute("message", "Username or Password incorrect!");
            model.addAttribute("type", "error");
            return "loginPage";
        }
        return "loginPage";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register" , new RegisterForm());
        return "registerPage";
    }

    @PostMapping("/register")
    public String addRegister(Model model, RedirectAttributes redirect,@RequestParam(name = "file") MultipartFile file,
                             @Valid  @ModelAttribute("register") RegisterForm form, BindingResult result, HttpServletRequest request) {
        String username = form.getUsername();
        String password = form.getPassword();
        String repassword = form.getRePassword();
        String email = form.getEmail();

        if (result.hasErrors()) {
            return "registerPage";
        }
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

            if (file.isEmpty()) {
                redirect.addFlashAttribute("message", " Vui lòng tải ảnh sản phẩm lên !");
                redirect.addFlashAttribute("type", "error");
                return "registerPage";
            }

            try {
                if (!file.isEmpty()) {
                    byte[] bytes;
                    bytes = file.getBytes();
                    Path path = Paths.get(pathFolder + file.getOriginalFilename());
                    Files.write(path, bytes);

                    TaiKhoan account = form.data(null);
                    account.setTrangthai(0);
                    account.setVaitro(1);
                    if (taiKhoanService.add(account) != null) {
                        redirect.addFlashAttribute("message" , "Đăng ký thành công !");
                        redirect.addFlashAttribute("type", "success");
                        return "redirect:/login";
                    }
                }

            }
            catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
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

    @GetMapping("/profile/{id}")
    public String getProfile(Model model, @PathVariable("id") Integer id){
        TaiKhoan user = taiKhoanService.getAccountById(id);
        model.addAttribute("account" , user);
        model.addAttribute("pro", new ThongTinForm());
        return"profilePage";

    }

    @GetMapping("/profile/edit/{id}")
    public String getEdit(Model model, @PathVariable("id") Integer id){
        TaiKhoan user = taiKhoanService.getAccountById(id);
        model.addAttribute("account" , user);
        model.addAttribute("edit", new ThongTinForm());
        return"profileUpdatePage";

    }


    @PostMapping("/profile/edit")
    public String edit(Model model, RedirectAttributes redirect, @ModelAttribute(name = "edit") ThongTinForm form,
                       BindingResult result, @RequestParam(name = "file") MultipartFile file, HttpServletRequest request){
        if (result.hasErrors()) {
            return "profilePage";
        }
        //Khong loi
        if (!result.hasErrors()) {
            try {
                TaiKhoan account = taiKhoanService.getAccountById(form.getIdtaikhoan());
                TaiKhoan acc = form.data(account);
                String anh = "";
                if (file.isEmpty()) {
                    anh = acc.getImage();
                } else {
                    anh = file.getOriginalFilename();
                    byte[] bytes;

                    bytes = file.getBytes();

                    Path path = Paths.get(pathFolder + file.getOriginalFilename());
                    Files.write(path, bytes);
                }
                acc.setImage(anh);
                acc.setTrangthai(0);
                acc.setVaitro(1);
                if (taiKhoanService.update(acc) != null) {
                    request.setAttribute("message", "Sửa thành công !");
                    request.setAttribute("type", "success");
                    return "profilePage";
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        return "profileUpdatePage";
    }


}
