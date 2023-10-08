package com.example.demo.bean;

import com.example.demo.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ChiTietSanPhamForm {

    private Integer idctsp;
    private BigDecimal gianhap;
    private BigDecimal giaban;
    private String mota;
    private Integer soluong;
    private Integer giamgia;
    private SanPham sanPham;
    private ThuongHieu thuongHieu;
    private NhaCungCap nhaCungCap;
    private KieuDang kieuDang;
    private KichThuoc kichThuoc;
    private ChatLieu chatLieu;
    private MauSac mauSac;
    private KhuyenMai khuyenMai;
    private Anh anh;

    public ChiTietSanPham data(ChiTietSanPham chiTietSanPham) {
        if (chiTietSanPham == null){
            chiTietSanPham = new ChiTietSanPham();
        }
        chiTietSanPham.setIdctsp(this.getIdctsp());
        chiTietSanPham.setGianhap(this.getGianhap());
        chiTietSanPham.setGiaban(this.getGiaban());
        chiTietSanPham.setMota(this.getMota());
        chiTietSanPham.setSoluong(this.getSoluong());
        chiTietSanPham.setGiamgia(this.getGiamgia());
        chiTietSanPham.setSanPham(this.getSanPham());
        chiTietSanPham.setThuongHieu(this.getThuongHieu());
        chiTietSanPham.setNhaCungCap(this.getNhaCungCap());
        chiTietSanPham.setKieuDang(this.getKieuDang());
        chiTietSanPham.setKichThuoc(this.getKichThuoc());
        chiTietSanPham.setChatLieu(this.getChatLieu());
        chiTietSanPham.setMauSac(this.getMauSac());
        chiTietSanPham.setKhuyenMai(this.getKhuyenMai());
        chiTietSanPham.setAnh(this.getAnh());
        return  chiTietSanPham;
    }
}
