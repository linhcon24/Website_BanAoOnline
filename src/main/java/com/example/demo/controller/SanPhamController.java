package com.example.demo.controller;

import com.example.demo.bean.KichThuocForm;
import com.example.demo.bean.SanPhamForm;
import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamService service;

    @GetMapping()
    public String showSP(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        Integer pageSize = 5;
        List<SanPham> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<SanPham> count = service.count();
        model.addAttribute("listSP", list);
        System.out.println(list.toString());
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminSP";
    }

    @GetMapping("/add")
    public String getAddSP(Model model){
        model.addAttribute("sp", new SanPham());
        return "adminSPAdd";
    }
    @PostMapping("/add")
    public String addSP(Model model, RedirectAttributes redirect, @ModelAttribute(name = "sp") SanPhamForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            String nextProductCode = service.generateNextProductCode();
            SanPham sanPham = form.data(null);
            sanPham.setMasanpham(nextProductCode); // Gán mã sản phẩm tự động
            sanPham.setTrangthai(0);
            if (service.add(sanPham) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/sanpham";
            }
        }
        return "adminSPAdd";
    }

    @GetMapping("/update/{id}")
    public String getUpdateSP(Model model, @PathVariable(name = "id") Integer id) {
        SanPham sanPham = service.getByIdSP(id);
        model.addAttribute("sp1", sanPham);
        model.addAttribute("sp", new SanPhamForm());
        return "adminSPUpdate";
    }
    @PostMapping("/update")
    public String updateSP(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") SanPhamForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            SanPham sanPham = service.getByIdSP(form.getIdsanpham());
            SanPham sp = form.data(sanPham);

            if (service.update(sp) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/sanpham";
            }
        }
        return "adminSPUpdate";
    }
    @GetMapping("/delete/{id}")
    public String xoaSP(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        SanPham sanPham = service.getByIdSP(id);
        if (service.delete(sanPham) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/sanpham";
        }
        return "adminSP";
    }
}
