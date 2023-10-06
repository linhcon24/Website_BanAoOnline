package com.example.demo.controller;

import com.example.demo.bean.LoaiKhuyenMaiForm;
import com.example.demo.bean.MauSacForm;
import com.example.demo.entity.LoaiKhuyenMai;
import com.example.demo.entity.MauSac;
import com.example.demo.service.LoaiKhuyenMaiService;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/loai-khuyen-mai")
public class LoaiKhuyenMaiController {
    @Autowired
    private LoaiKhuyenMaiService service;
    @GetMapping("/back")
    public String back(){
        return "redirect:/admin/loai-khuyen-mai";
    }

    @GetMapping()
    public String showTH(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        Integer pageSize = 5;
        List<LoaiKhuyenMai> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<LoaiKhuyenMai> count = service.count();
        model.addAttribute("listLKM", list);
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
//        list.toString();
        return "adminLKM";
    }
    @GetMapping("/add")
    public String getAddMauSac(Model model) {
        model.addAttribute("lkm", new LoaiKhuyenMai());
        return "adminLKMAdd";
    }
    @PostMapping("/add")
    public String addMS(Model model, RedirectAttributes redirect, @ModelAttribute(name = "ms") LoaiKhuyenMaiForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            LoaiKhuyenMai loaiKhuyenMai = form.data(null);
            loaiKhuyenMai.setTrangthai(0);
            if (service.add(loaiKhuyenMai) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/loai-khuyen-mai";
            }

        }

        return "adminLKMAdd";
    }
    @GetMapping("/update/{id}")
    public String getUpdateMS(Model model, @PathVariable(name = "id") Integer id) {
        LoaiKhuyenMai loaiKhuyenMai = service.getByIdLKM(id);
        model.addAttribute("lkm1", loaiKhuyenMai);
        model.addAttribute("lkm", new LoaiKhuyenMaiForm());
        return "adminLKMUpdate";
    }

    @PostMapping("/update")
    public String updateMS(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") LoaiKhuyenMaiForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            LoaiKhuyenMai loaiKhuyenMai = service.getByIdLKM(form.getIdloaikhuyenmai());
            LoaiKhuyenMai lkm = form.data(loaiKhuyenMai);
            loaiKhuyenMai.setTrangthai(0);
            if (service.update(lkm) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/loai-khuyen-mai";
            }
        }
        return "adminLKMUpdate";

    }
    @GetMapping("/delete/{id}")
    public String xoaMS(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        LoaiKhuyenMai mauSac = service.getByIdLKM(id);
        if (service.delete(mauSac) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/loai-khuyen-mai";
        }
        return "adminLKM";
    }
    @GetMapping("/detail/{id}")
    public String xemChiTiet(Model model, @PathVariable(name = "id") Integer id) {
        LoaiKhuyenMai mauSac = service.getByIdLKM(id);
        model.addAttribute("lkm",mauSac);
        return "adminLKMDetail";
    }
}
