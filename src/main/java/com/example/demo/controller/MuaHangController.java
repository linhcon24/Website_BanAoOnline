package com.example.demo.controller;

import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.HoaDon;
import com.example.demo.repository.GioHangChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/mua-hang")
public class MuaHangController {
    @Autowired
    private GioHangChiTietRepository iGioHangService;
    @Autowired
    private HomePage iHoaDonService;


    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable(name = "id") UUID id) {
        GioHangChiTiet gioHangChiTiet = iGioHangService.findAllById(id);
        model.addAttribute("tongTien", gioHangChiTiet.getDongia());
        model.addAttribute("gioHangChiTiet", gioHangChiTiet);
        return "trang-thanh-toan";
    }

    @GetMapping("/thanh-toan/{id}")
    public String thanhToan(Model model, @ModelAttribute("hoaDon") HoaDon hoaDonForm, @PathVariable("id") String idGioHangChiTiet) {
        iHoaDonService.save(hoaDonForm, idGioHangChiTiet);
        model.addAttribute("message", "THANH TOÁN-THÀNH-CÔNG");
        return "redirect:/ban-hang/san-pham";
    }

}