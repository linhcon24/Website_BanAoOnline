package com.example.demo.bean;

import com.example.demo.entity.LoaiKhuyenMai;
import com.example.demo.entity.MauSac;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class LoaiKhuyenMaiForm {
    private Integer idloaikhuyenmai;
    private String maloaikhuyenmai;
    private String tenloaikhuyenmai;
    private Date ngaytao;
    private Date ngaycapnhat;
    private String nguoicapnhat;
    private Integer trangthai;

    public LoaiKhuyenMai data(LoaiKhuyenMai loaiKhuyenMai){
        if (loaiKhuyenMai == null){
            loaiKhuyenMai = new LoaiKhuyenMai();
        }
        loaiKhuyenMai.setMaloaikhuyenmai(this.getMaloaikhuyenmai());
        loaiKhuyenMai.setTenloaikhuyenmai(this.getTenloaikhuyenmai());
        loaiKhuyenMai.setNgaytao(this.getNgaytao());
        loaiKhuyenMai.setNgaycapnhat(this.getNgaycapnhat());
        loaiKhuyenMai.setNguoicapnhat(this.getNguoicapnhat());
        loaiKhuyenMai.setTrangthai(this.getTrangthai());
        return loaiKhuyenMai;
    }
}
