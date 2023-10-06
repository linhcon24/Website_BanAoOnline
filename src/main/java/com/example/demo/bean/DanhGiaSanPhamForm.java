package com.example.demo.bean;

import com.example.demo.entity.DanhGiaSanPham;
import com.example.demo.entity.SanPham;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class DanhGiaSanPhamForm {
    private UUID iddanhgia;
    private String madanhgia;
    private String noidung;
    private SanPham sanPham;


    public DanhGiaSanPham data(DanhGiaSanPham danhGiaSanPham){
        if (danhGiaSanPham == null){
            danhGiaSanPham = new DanhGiaSanPham();
        }
        danhGiaSanPham.setMadanhgia(this.getMadanhgia());
        danhGiaSanPham.setNoidung(this.getNoidung());
        danhGiaSanPham.setSanPham(this.getSanPham());
        return danhGiaSanPham;
    }

}
