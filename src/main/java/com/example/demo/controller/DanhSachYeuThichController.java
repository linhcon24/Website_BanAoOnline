package com.example.demo.controller;

import com.example.demo.entity.DanhSachYeuThich;
import com.example.demo.service.DanhSachYeuThichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/danh-sach-yeu-thich")
public class DanhSachYeuThichController {

    @Autowired
    private DanhSachYeuThichService service;

    @GetMapping()
    public String showDanhSachYeuThich(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        Integer pageSize = 5;
        List<DanhSachYeuThich> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<DanhSachYeuThich> count = service.count();
        model.addAttribute("listDSYT", list);
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminDSYT";
    }
}
