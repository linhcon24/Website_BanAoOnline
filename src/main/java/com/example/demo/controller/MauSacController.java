package com.example.demo.controller;

import com.example.demo.bean.MauSacForm;
import com.example.demo.entity.MauSac;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacService service;
//    private ThuongHieuRepository repository;
    @GetMapping("/back")
    public String back(){
        return "redirect:/admin/mau-sac";
    }

    @GetMapping()
    public String showTH(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        Integer pageSize = 5;
        List<MauSac> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<MauSac> count = service.count();
        model.addAttribute("list", list);
        System.out.println(list.toString());
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
//        list.toString();
        return "adminMS";
    }
    @GetMapping("/add")
    public String getAddMauSac(Model model) {
        model.addAttribute("ms", new MauSac());
        return "adminMSAdd";
    }
    @PostMapping("/add")
    public String addMS(Model model, RedirectAttributes redirect, @ModelAttribute(name = "ms")MauSacForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            MauSac mauSac = form.data(null);
            mauSac.setTrangthai(0);
            if (service.add(mauSac) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/mau-sac";
            }

        }

        return "adminMSAdd";
    }
    @GetMapping("/update/{id}")
    public String getUpdateMS(Model model, @PathVariable(name = "id") Integer id) {
        MauSac mauSac = service.getByIdMS(id);
        model.addAttribute("ms1", mauSac);
        model.addAttribute("ms", new MauSacForm());
        return "adminMSUpdate";
    }

    @PostMapping("/update")
    public String updateMS(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") MauSacForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            MauSac mauSac = service.getByIdMS(form.getIdmausac());
            MauSac ms = form.data(mauSac);

            if (service.update(ms) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/mau-sac";
            }
        }
        return "adminMSUpdate";

    }
    @GetMapping("/delete/{id}")
    public String xoaMS(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        MauSac mauSac = service.getByIdMS(id);
        if (service.delete(mauSac) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/mau-sac";
        }
        return "adminMS";
    }

}
