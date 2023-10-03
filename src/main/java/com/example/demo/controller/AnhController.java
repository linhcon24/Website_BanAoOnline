package com.example.demo.controller;

import com.example.demo.bean.AnhForm;
import com.example.demo.entity.Anh;
import com.example.demo.service.AnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/anhs")
public class AnhController {

    @Autowired
    private AnhService service;

    @GetMapping()
    public String showAnh(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        Integer pageSize = 5;
        List<Anh> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<Anh> count = service.count();
        model.addAttribute("listAnh", list);
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminAnh";
    }

    @GetMapping("/add")
    public String getAddAnh(Model model){
        model.addAttribute("anh", new Anh());
        return "adminAnhAdd";
    }
    @PostMapping("/add")
    public String addAnh(Model model, RedirectAttributes redirect, @ModelAttribute(name = "anh") AnhForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            Anh anh = form.data(null);
            anh.setTrangthai(0);
            if (service.add(anh) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/anhs";
            }
        }
        return "adminAnhAdd";
    }
    @GetMapping("/update/{id}")
    public String getUpdateAnh(Model model, @PathVariable(name = "id") UUID id) {
        Anh a = service.getByIdA(id);
        model.addAttribute("anh1", a);
        model.addAttribute("anh", new AnhForm());
        return "adminAnhUpdate";
    }
    @PostMapping("/update")
    public String updateAnh(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") AnhForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            Anh anh = service.getByIdA(form.getIdimage());
            Anh a = form.data(anh);

            if (service.update(a) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/anhs";
            }
        }
        return "adminAnhUpdate";
    }
    @GetMapping("/delete/{id}")
    public String xoaAnh(Model model, @PathVariable(name = "id") UUID id, RedirectAttributes redirect) {
        Anh anh = service.getByIdA(id);
        if (service.delete(anh) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/anhs";
        }
        return "adminAnh";
    }
}
