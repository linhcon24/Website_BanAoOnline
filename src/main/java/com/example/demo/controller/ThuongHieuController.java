package com.example.demo.controller;


import com.example.demo.bean.ThuongHieuForm;
import com.example.demo.entity.ThuongHieu;

import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/thuong-hieu")
public class ThuongHieuController {

    @Autowired
    private ThuongHieuService service;
//    private ThuongHieuRepository repository;

    @GetMapping()
    public String showTH(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        Integer pageSize = 5;
        List<ThuongHieu> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<ThuongHieu> count = service.count();
        model.addAttribute("list", list);
        System.out.println(list.toString());
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
//        list.toString();
        return "adminTH";
    }

    @GetMapping("/add")
    public String getAddTH(Model model) {
        model.addAttribute("th", new ThuongHieu());
        return "adminTHAdd";
    }

    @PostMapping("/add")
    public String addTH(Model model, RedirectAttributes redirect, @ModelAttribute(name = "th") ThuongHieuForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            ThuongHieu thuongHieu = form.data(null);
            thuongHieu.setTrangthai(0);
            if (service.add(thuongHieu) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/thuong-hieu";
            }

        }

        return "adminTHAdd";
    }

    @GetMapping("/update/{id}")
    public String getUpdateTH(Model model, @PathVariable(name = "id") Integer id) {
        ThuongHieu thuongHieu = service.getByIdTH(id);
        model.addAttribute("th1", thuongHieu);
        model.addAttribute("th", new ThuongHieuForm());
        return "adminTHUpdate";
    }

    @PostMapping("/update")
    public String updateTH(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") ThuongHieuForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            ThuongHieu thuongHieu = service.getByIdTH(form.getIdthuonghieu());
            ThuongHieu th = form.data(thuongHieu);

            if (service.update(th) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/thuong-hieu";
            }
        }
        return "adminTHUpdate";

    }


    @GetMapping("/delete/{id}")
    public String xoaTH(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        ThuongHieu thuongHieu = service.getByIdTH(id);
        if (service.delete(thuongHieu) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/thuong-hieu";
        }
        return "adminTH";
    }
}
