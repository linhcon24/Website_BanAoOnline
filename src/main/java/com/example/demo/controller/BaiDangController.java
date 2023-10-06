package com.example.demo.controller;

import com.example.demo.bean.BaiDangForm;
import com.example.demo.entity.BaiDang;
import com.example.demo.service.BaiDangService;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/bai-dang")
public class BaiDangController {

    @Autowired
    private BaiDangService service;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping()
    public String showKT(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        Integer pageSize = 5;
        List<BaiDang> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<BaiDang> count = service.count();
        model.addAttribute("listBD", list);
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminBD";
    }

    @GetMapping("/add")
    public String getAddKT(Model model){
        model.addAttribute("listtk", taiKhoanService.count());
        model.addAttribute("bd", new BaiDang());
        return "adminBDAdd";
    }
    @PostMapping("/add")
    public String addKT(Model model, RedirectAttributes redirect, @ModelAttribute(name = "kt") BaiDangForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            BaiDang kichThuoc = form.data(null);
            kichThuoc.setTrangthai(0);
            if (service.add(kichThuoc) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/bai-dang";
            }
        }
        return "adminBDAdd";
    }

    @GetMapping("/update/{id}")
    public String getUpdateKT(Model model, @PathVariable(name = "id") String id) {
        BaiDang kichThuoc = service.getByIdBD(UUID.fromString(id));
        model.addAttribute("bd1", kichThuoc);
        model.addAttribute("listtk", taiKhoanService.count());
        model.addAttribute("bd", new BaiDangForm());

        return "adminBDUpdate";
    }
    @PostMapping("/update")
    public String updateKT(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") BaiDangForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            BaiDang kichThuoc = service.getByIdBD(form.getIdbaidang());
            BaiDang kt = form.data(kichThuoc);

            if (service.update(kt) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/bai-dang";
            }
        }
        return "adminBDUpdate";
    }
    @GetMapping("/delete/{id}")
    public String xoaKT(Model model, @PathVariable(name = "id") String id, RedirectAttributes redirect) {
        BaiDang kichThuoc = service.getByIdBD(UUID.fromString(id));
        if (service.delete(kichThuoc) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/bai-dang";
        }
        return "adminBD";
    }
}
