package com.example.demo.controller;

import com.example.demo.bean.NhaCungCapForm;
import com.example.demo.entity.NhaCungCap;
import com.example.demo.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/nha-cung-cap")
public class NhaCungCapController {
    @Autowired
    private NhaCungCapService service;
//    private ThuongHieuRepository repository;

    @GetMapping()
    public String showNCC(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        Integer pageSize = 5;
        List<NhaCungCap> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<NhaCungCap> count = service.count();
        model.addAttribute("list", list);
        System.out.println(list.toString());
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
//        list.toString();
        return "adminNCC";
    }
    @GetMapping("/add")
    public String getAddNhaCungCap(Model model) {
        model.addAttribute("ncc", new NhaCungCap());
        return "adminNCCAdd";
    }
    @PostMapping("/add")
    public String addNCC(Model model, RedirectAttributes redirect, @ModelAttribute(name = "ncc") NhaCungCapForm form,
                         BindingResult result) {
        if (!result.hasErrors()) {
            NhaCungCap nhaCungCap = form.data(null);
            nhaCungCap.setTrangthai(0);
            if (service.add(nhaCungCap) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/nha-cung-cap";
            }

        }

        return "adminNCCAdd";
    }
    @GetMapping("/update/{id}")
    public String getUpdateNCC(Model model, @PathVariable(name = "id") Integer id) {
        NhaCungCap nhaCungCap = service.getByIdNCC(id);
        model.addAttribute("ncc1", nhaCungCap);
        model.addAttribute("ncc", new NhaCungCapForm());
        return "adminNCCUpdate";
    }

    @PostMapping("/update")
    public String updateNCC(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") NhaCungCapForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            NhaCungCap nhaCungCap = service.getByIdNCC(form.getIdnhacungcap());
            NhaCungCap ncc = form.data(nhaCungCap);

            if (service.update(ncc) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/nha-cung-cap";
            }
        }
        return "adminNCCUpdate";

    }
    @GetMapping("/delete/{id}")
    public String xoaNCC(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        NhaCungCap nhaCungCap = service.getByIdNCC(id);
        if (service.delete(nhaCungCap) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/nha-cung-cap";
        }
        return "adminNCC";
    }

}
