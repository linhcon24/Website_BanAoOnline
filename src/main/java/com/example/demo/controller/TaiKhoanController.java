package com.example.demo.controller;

import com.example.demo.bean.TaiKhoanForm;
import com.example.demo.bean.ThuongHieuForm;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin/tai-khoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService service;

    @Value("${upload.path}")
    private String pathFolder;


    @GetMapping()
    public String showAcc(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        Integer pageSize = 8;
        List<TaiKhoan> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<TaiKhoan> count = service.count();
        model.addAttribute("listAccount", list);
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        return "adminAcc";
    }

    @GetMapping("/add")
    public String getAddTK(Model model) {
        model.addAttribute("tk", new TaiKhoanForm());
        return "adminAccAdd";
    }

    @PostMapping("/add")
    public String addTH(Model model, RedirectAttributes redirect,@Valid @ModelAttribute(name = "tk") TaiKhoanForm form,
                        BindingResult result, @RequestParam(name = "file") MultipartFile file) {
        if (result.hasErrors()) {
            return "adminAccAdd";
        }

        if (service.getByUsername(form.getUsername()) != null) {
            redirect.addFlashAttribute("message", "Tài khoản đã tòn tại trên hệ thống!");
            redirect.addFlashAttribute("type", "error");
            return "adminAccAdd";
        }

        if (file.isEmpty()) {
            redirect.addFlashAttribute("message", " Vui lòng tải ảnh sản phẩm lên !");
            redirect.addFlashAttribute("type", "error");
            return "adminAccAdd";
        }
        try {
            if (!file.isEmpty()) {
                byte[] bytes;
                bytes = file.getBytes();
                Path path = Paths.get(pathFolder + file.getOriginalFilename());
                Files.write(path, bytes);

                TaiKhoan account = form.data(null);
                account.setTrangthai(0);
                if (service.add(account) != null) {
                    redirect.addFlashAttribute("message", "Thêm thành công !");
                    redirect.addFlashAttribute("type", "success");
                    return "redirect:/admin/tai-khoan";
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "adminAccAdd";
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable(name = "id") Integer id) {
        TaiKhoan taiKhoan = service.getAccountById(id);
        model.addAttribute("account", taiKhoan);
        model.addAttribute("tk", new TaiKhoanForm());
        return "adminAccUpdate";
    }

    @PostMapping("/update")
    public String updateTK(Model model, RedirectAttributes redirect, @ModelAttribute(name = "tk") TaiKhoanForm form,
                           BindingResult result, @RequestParam(name = "file") MultipartFile file) {
        if (result.hasErrors()) {
            return "adminAccUpdate";
        }
        //Khong loi
        if (!result.hasErrors()) {
            try {
                TaiKhoan account = service.getAccountById(form.getIdtaikhoan());
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
                if (service.update(acc) != null) {
                    redirect.addFlashAttribute("message", "Sửa thành công !");
                    redirect.addFlashAttribute("type", "success");
                    return "redirect:/admin/tai-khoan";
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return "adminAccUpdate";
    }


    @GetMapping("/delete/{id}")
    public String deleteTK(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        TaiKhoan taiKhoan = service.getAccountById(id);
        if (service.delete(taiKhoan) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/tai-khoan";
        }
        return "adminAcc";
    }


}
