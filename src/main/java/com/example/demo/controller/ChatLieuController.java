package com.example.demo.controller;

import com.example.demo.bean.ChatLieuForm;
import com.example.demo.entity.ChatLieu;
import com.example.demo.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/chat-lieu")
public class ChatLieuController {

    @Autowired
    private ChatLieuService service;
    @GetMapping()
    public String showCL(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        Integer pageSize = 5;
        List<ChatLieu> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<ChatLieu> count = service.count();
        model.addAttribute("list", list);
        System.out.println(list.toString());
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminCL";
    }
    @GetMapping("/add")
    public String getAddCL(Model model){
        model.addAttribute("cl", new ChatLieu());
        return "adminCLAdd";
    }
    @PostMapping("/add")
    public String addCL(Model model, RedirectAttributes redirect, @ModelAttribute(name = "cl") ChatLieuForm form,
                        BindingResult result) {
        if (!result.hasErrors()) {
            ChatLieu chatLieu = form.data(null);
            chatLieu.setTrangthai(0);
            if (service.add(chatLieu) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/chat-lieu";
            }

        }
        return "adminCLAdd";
    }
    @GetMapping("/update/{id}")
    public String getUpdateCL(Model model, @PathVariable(name = "id") Integer id) {
        ChatLieu chatLieu = service.getByIdCL(id);
        model.addAttribute("cl1", chatLieu);
        model.addAttribute("cl", new ChatLieuForm());
        return "adminCLUpdate";
    }
    @PostMapping("/update")
    public String updateCL(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") ChatLieuForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            ChatLieu chatLieu = service.getByIdCL(form.getIdchatlieu());
            ChatLieu cl = form.data(chatLieu);

            if (service.update(cl) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/chat-lieu";
            }
        }
        return "adminCLUpdate";
    }
    @GetMapping("/delete/{id}")
    public String xoaCL(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        ChatLieu chatLieu = service.getByIdCL(id);
        if (service.delete(chatLieu) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/chat-lieu";
        }
        return "adminCL";
    }
}
