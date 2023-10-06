package com.example.demo.controller;

import com.example.demo.bean.DanhGiaSanPhamForm;
import com.example.demo.entity.DanhGiaSanPham;
import com.example.demo.service.DanhGiaSanPhamService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/danh-gia-san-pham")
public class DanhGiaSanPhamController {
    @Autowired
    private DanhGiaSanPhamService service;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping()
    public String showDanhSach(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        Integer pageSize = 5;
        List<DanhGiaSanPham> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<DanhGiaSanPham> count = service.count();
        model.addAttribute("listDGSP", list);
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminDGSP";
    }

    @GetMapping("/add")
    public String getAddKT(Model model) {
        model.addAttribute("listSP", sanPhamService.count());
        model.addAttribute("listTK", taiKhoanService.count());
        model.addAttribute("kt", new DanhGiaSanPham());
        return "adminDGSPAdd";
    }

    @PostMapping("/add")
    public String addKT(Model model, RedirectAttributes redirect, @ModelAttribute(name = "kt") DanhGiaSanPhamForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            DanhGiaSanPham danhGiaSanPham = form.data(null);
            danhGiaSanPham.setTrangthai(0);
            if (service.add(danhGiaSanPham) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/danh-gia-san-pham";
            }
        }
        return "adminDGSPAdd";
    }

    @GetMapping("/update/{id}")
    public String getUpdateKT(Model model, @PathVariable(name = "id") String id) {
        DanhGiaSanPham kichThuoc = service.getByIdDGSP(id);
        model.addAttribute("kt1", kichThuoc);
        model.addAttribute("listSP", sanPhamService.count());
        model.addAttribute("listTK", taiKhoanService.count());
        model.addAttribute("kt", new DanhGiaSanPhamForm());
        return "adminDGSPUpdate";
    }

    @PostMapping("/update")
    public String updateKT(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") DanhGiaSanPhamForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            System.out.println(form.getIddanhgia().toString());
            DanhGiaSanPham danhGiaSanPham = service.getByIdDGSP(form.getIddanhgia().toString());
            DanhGiaSanPham kt = form.data(danhGiaSanPham);

            if (service.update(kt) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/danh-gia-san-pham";
            }
        }
        return "adminDGSPUpdate";
    }

    @GetMapping("/delete/{id}")
    public String xoaKT(Model model, @PathVariable(name = "id") String id, RedirectAttributes redirect) {
        DanhGiaSanPham kichThuoc = service.getByIdDGSP(id);
        if (service.delete(kichThuoc) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/danh-gia-san-pham";
        }
        return "adminDGSP";
    }

}

