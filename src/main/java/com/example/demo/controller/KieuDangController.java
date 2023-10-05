package com.example.demo.controller;

import com.example.demo.bean.KieuDangForm;
import com.example.demo.entity.KieuDang;
import com.example.demo.service.KieuDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/kieu-dang")
public class KieuDangController {
    @Autowired
    private KieuDangService service;
//    private ThuongHieuRepository repository;

    @GetMapping()
    public String showNCC(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        Integer pageSize = 5;
        List<KieuDang> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<KieuDang> count = service.count();
        model.addAttribute("listKD", list);
        System.out.println(list.toString());
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
//        list.toString();
        return "adminKD";
    }
    @GetMapping("/add")
    public String getAddNKieuDang(Model model) {
        model.addAttribute("kd", new KieuDang());
        return "adminKDAdd";
    }
    @PostMapping("/add")
    public String addKD(Model model, RedirectAttributes redirect, @ModelAttribute(name = "kd") KieuDangForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            KieuDang kieuDang = form.data(null);
            kieuDang.setTrangthai(0);
            if (service.add(kieuDang) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/kieu-dang";
            }

        }

        return "adminKDAdd";
    }
    @GetMapping("/update/{id}")
    public String getUpdateKD(Model model, @PathVariable(name = "id") Integer id) {
        KieuDang kieuDang = service.getByIdKD(id);
        model.addAttribute("kd1", kieuDang);
        model.addAttribute("kd", new KieuDangForm());
        return "adminKDUpdate";
    }

    @PostMapping("/update")
    public String updateKD(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") KieuDangForm form,
                            BindingResult result) {
        if (!result.hasErrors()) {
            KieuDang kieuDang = service.getByIdKD(form.getIdkieudang());
            KieuDang kd = form.data(kieuDang);

            if (service.update(kd) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/kieu-dang";
            }
        }
        return "adminKDUpdate";

    }
    @GetMapping("/delete/{id}")
    public String xoaNCC(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        KieuDang kieuDang = service.getByIdKD(id);
        if (service.delete(kieuDang) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/kieu-dang";
        }
        return "adminKD";
    }
}
