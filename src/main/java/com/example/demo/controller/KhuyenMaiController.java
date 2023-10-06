package com.example.demo.controller;

import com.example.demo.bean.KhuyenMaiForm;
import com.example.demo.bean.KichThuocForm;
import com.example.demo.entity.KhuyenMai;
import com.example.demo.service.KhuyenMaiService;
import com.example.demo.service.LoaiKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/khuyen-mai")
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiService service;

    @Autowired
    private LoaiKhuyenMaiService loaiKhuyenMaiService;

    @GetMapping()
    public String showKT(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        Integer pageSize = 5;
        List<KhuyenMai> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<KhuyenMai> count = service.count();
        model.addAttribute("listKM", list);
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminKM";
    }

    @GetMapping("/add")
    public String getAddKT(Model model){
        model.addAttribute("kt", new KhuyenMai());
        model.addAttribute("listKM", loaiKhuyenMaiService.count());
        return "adminKMAdd";
    }
    @PostMapping("/add")
    public String addKT(Model model, RedirectAttributes redirect, @ModelAttribute(name = "kt") KhuyenMaiForm form,
                        BindingResult result) {
            KhuyenMai kichThuoc = form.data(null);
            if (service.add(kichThuoc) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/khuyen-mai";
            }
        return "redirect:/admin/khuyen-mai/add";
    }

    @GetMapping("/update/{id}")
    public String getUpdateKT(Model model, @PathVariable(name = "id") Integer id) {
        KhuyenMai khuyenMai = service.getByIdKM(id);
        model.addAttribute("km1", khuyenMai);
        model.addAttribute("listKM", loaiKhuyenMaiService.count());
        model.addAttribute("km", new KhuyenMaiForm());
        return "adminKMUpdate";
    }
    @PostMapping("/update")
    public String updateKT(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") KhuyenMaiForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            KhuyenMai khuyenMai = service.getByIdKM(form.getIdkhuyenmai());
            KhuyenMai km = form.data(khuyenMai);

            if (service.update(km) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/khuyen-mai";
            }
        }
        return "adminKMUpdate";
    }
    @GetMapping("/delete/{id}")
    public String xoaKT(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        KhuyenMai kichThuoc = service.getByIdKM(id);
        if (service.delete(kichThuoc) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/khuyen-mai";
        }
        return "adminKM";
    }
}
