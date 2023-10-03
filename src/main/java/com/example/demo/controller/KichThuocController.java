package com.example.demo.controller;

import com.example.demo.bean.ChatLieuForm;
import com.example.demo.bean.KichThuocForm;
import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KichThuoc;
import com.example.demo.service.ChatLieuService;
import com.example.demo.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/kich-thuoc")
public class KichThuocController {

    @Autowired
    private KichThuocService service;

    @GetMapping()
    public String showKT(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        Integer pageSize = 5;
        List<KichThuoc> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<KichThuoc> count = service.count();
        model.addAttribute("listKT", list);
        System.out.println(list.toString());
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminKT";
    }

    @GetMapping("/add")
    public String getAddKT(Model model){
        model.addAttribute("kt", new KichThuoc());
        return "adminKTAdd";
    }
    @PostMapping("/add")
    public String addKT(Model model, RedirectAttributes redirect, @ModelAttribute(name = "kt") KichThuocForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            KichThuoc kichThuoc = form.data(null);
            kichThuoc.setTrangthai(0);
            if (service.add(kichThuoc) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/kich-thuoc";
            }
        }
        return "adminKTAdd";
    }

    @GetMapping("/update/{id}")
    public String getUpdateKT(Model model, @PathVariable(name = "id") Integer id) {
        KichThuoc kichThuoc = service.getByIdKT(id);
        model.addAttribute("kt1", kichThuoc);
        model.addAttribute("kt", new KichThuocForm());
        return "adminKTUpdate";
    }
    @PostMapping("/update")
    public String updateKT(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") KichThuocForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            KichThuoc kichThuoc = service.getByIdKT(form.getIdkichthuoc());
            KichThuoc kt = form.data(kichThuoc);

            if (service.update(kt) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/kich-thuoc";
            }
        }
        return "adminKTUpdate";
    }
    @GetMapping("/delete/{id}")
    public String xoaKT(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        KichThuoc kichThuoc = service.getByIdKT(id);
        if (service.delete(kichThuoc) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/kich-thuoc";
        }
        return "adminKT";
    }
}
