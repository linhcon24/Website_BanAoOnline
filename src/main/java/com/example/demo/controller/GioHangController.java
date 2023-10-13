package com.example.demo.controller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
public class GioHangController {
    @Autowired
    HttpSession session;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;
    Page<GioHangChiTiet> listGioHangChiTiet;

    @GetMapping("/increase")
    public String increaseCartProduct(Model model, @RequestParam(name = "idGHCT") UUID idGHCT){
        GioHangChiTiet ghct = gioHangChiTietService.getByIdGHCT(idGHCT);
        ChiTietSanPham ctsp = chiTietSanPhamService.getByIdCTSP(ghct.getChiTietSanPham().getIdctsp());
        int quantity = 0;
        if (ctsp.getSoluong() == ghct.getSoluong()){
            return "redirect:/cart";
        }
        quantity = ghct.getSoluong() + 1;
        ghct.setSoluong(quantity);
        gioHangChiTietService.update(ghct);
        return "redirect:/cart";
    }

    @GetMapping("/reduce")
    public String reduceCartProduct(Model model, @RequestParam(name = "idGHCT") UUID idGHCT){
        GioHangChiTiet ghct = gioHangChiTietService.getByIdGHCT(idGHCT);
        int quantity = 0;
        if (ghct.getSoluong() < 2){
            return "redirect:/cart";
        }
        quantity = ghct.getSoluong() - 1;
        ghct.setSoluong(quantity);
        gioHangChiTietService.update(ghct);
        return "redirect:/cart";
    }
}
