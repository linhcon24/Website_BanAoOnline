package com.example.demo.controller;

import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class GioHangController {
    @Autowired
    HttpSession session;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;
    Page<GioHangChiTiet> listGioHangChiTiet;

}
