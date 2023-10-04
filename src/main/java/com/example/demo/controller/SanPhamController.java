package com.example.demo.controller;

import com.example.demo.service.SanPhamService;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamService service;


}
