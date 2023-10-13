package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.GioHangChiTietService;
import com.example.demo.service.KichThuocService;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class DetailOrAddToCartController {

    @Autowired
    HttpSession session;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private KichThuocService kichThuocService;


    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    private List<ChiTietSanPham> listChiTietSanPham;
    private List<MauSacViewModel> listMauSacCTSP;
    private List<KichThuocViewModel> listKichThuocCTSP;
    private List<GioHangChiTiet> listGioHangChiTiet;

    @GetMapping("/detail")
    public String detailProduct(Model model, @RequestParam(name = "id") Integer idSanPham){
        listChiTietSanPham = chiTietSanPhamService.getListByIdSanPham(idSanPham);
        ChiTietSanPham ctsp = listChiTietSanPham.get(0);
        listMauSacCTSP = mauSacService.getListMauSacBySP(idSanPham);
        listKichThuocCTSP = kichThuocService.getListKichThuocBySP(idSanPham);
        model.addAttribute("ctsp",ctsp);
        model.addAttribute("list",listChiTietSanPham);
        model.addAttribute("listMauSac",listMauSacCTSP);
        model.addAttribute("listKichThuoc",listKichThuocCTSP);
        return "detailProduct";
    }

    @PostMapping("/add-to-cart")
    public String AddToCart(Model model,
                            RedirectAttributes redirect,
                            @RequestParam(name = "idSanPham") Integer idSanPham,
                            @RequestParam(name = "idCTSP") Integer idCTSP){
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("account");
        if (taiKhoan == null){
            redirect.addFlashAttribute("message", "Vui lòng đăng nhập");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/login";
        }

        listGioHangChiTiet = gioHangChiTietService.count(taiKhoan.getIdtaikhoan());

        for (GioHangChiTiet o: listGioHangChiTiet){
            if (o.getChiTietSanPham() == chiTietSanPhamService.getByIdCTSP(idCTSP)){
                redirect.addFlashAttribute("message", "Sản phẩm hiện đã có trong giỏ hàng");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/product";
            }
        }


        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        gioHangChiTiet.setChiTietSanPham(chiTietSanPhamService.getByIdCTSP(idCTSP));
        gioHangChiTiet.setDongia(listChiTietSanPham.get(0).getGiaban().doubleValue());
        gioHangChiTiet.setSoluong(1);
        gioHangChiTiet.setGiamgia(null);
        gioHangChiTiet.setGioHang(listGioHangChiTiet.get(0).getGioHang());
        gioHangChiTietService.add(gioHangChiTiet);
        redirect.addFlashAttribute("message", "Sản phẩm đã được thêm vào giỏ hàng");
        redirect.addFlashAttribute("type", "success");
        return "redirect:/cart";
    }
}
