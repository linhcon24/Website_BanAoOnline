package com.example.demo.bean;

import com.example.demo.entity.SanPham;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPhamForm {

    private Integer idsanpham;
    private String masanpham;
    private String tensanpham;

    public SanPham data(SanPham sanPham) {
        if (sanPham == null){
            sanPham = new SanPham();
        }
        sanPham.setIdsanpham(this.getIdsanpham());
        sanPham.setMasanpham(this.getMasanpham());
        sanPham.setTensanpham(this.getTensanpham());
        return  sanPham;
    }
}
