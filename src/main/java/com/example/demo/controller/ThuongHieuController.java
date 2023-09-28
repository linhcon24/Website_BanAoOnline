package com.example.demo.controller;


import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.ThuongHieuRepository;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/thuong-hieu")
public class ThuongHieuController {

    @Autowired
    private ThuongHieuService service;
//    private ThuongHieuRepository repository;

    @GetMapping()
    public String showTH(Model model,@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        Integer pageSize = 5;
        List<ThuongHieu> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<ThuongHieu> count = service.count();
        model.addAttribute("list" ,list);
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminTH";
    }

//    @GetMapping("/hien-thi")
//    public String getAll(Model model){
//       List<ThuongHieu> th = repository.findAll();
//        model.addAttribute("hiTH" , th);
//
//        System.out.println(th.toString());
//        return "admin/thuonghieu/thuong-hieu";
//    }


}
