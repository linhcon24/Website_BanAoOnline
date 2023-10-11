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
    public String AddToCart(RedirectAttributes redirect,
                            @RequestParam(name = "id") Integer idSanPham,
                            @RequestParam(name = "mauSac") Integer idMauSac,
                            @RequestParam(name = "kichThuoc") Integer idKichThuoc,
                            @RequestParam(name = "soLuong") Integer soLuong){
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("account");
        if (taiKhoan == null){
            return "loginPage";
        }

//        listChiTietSanPham = chiTietSanPhamService.getListSPByMSandKT(idSanPham,idMauSac,idKichThuoc);
        listGioHangChiTiet = gioHangChiTietService.count(taiKhoan.getIdtaikhoan());

        if (listChiTietSanPham == null){
            redirect.addFlashAttribute("message", "Sản phẩm hiện đã hết hàng");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/product";
        }

        if (listChiTietSanPham.get(0).getSoluong() < soLuong){
            redirect.addFlashAttribute("message", "Sản phẩm không đú số lượng");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/product";
        }



            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setChiTietSanPham(listChiTietSanPham.get(0));
            gioHangChiTiet.setDongia(listChiTietSanPham.get(0).getGiaban().doubleValue());
            gioHangChiTiet.setSoluong(soLuong);
            gioHangChiTiet.setGiamgia(null);
            gioHangChiTiet.setGioHang(listGioHangChiTiet.get(0).getGioHang());
            redirect.addFlashAttribute("message", "Sản phẩm đã được thêm vào giỏ hàng");
            redirect.addFlashAttribute("type", "success");
            return "cartPage";

    }
}
