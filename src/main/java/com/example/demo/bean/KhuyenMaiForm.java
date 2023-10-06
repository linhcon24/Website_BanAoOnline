package com.example.demo.bean;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.entity.LoaiKhuyenMai;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
public class KhuyenMaiForm {
    private Integer idkhuyenmai;
    private String makhuyenmai;
    private String tenkhuyenmai;
    private String mota;
    private Integer chietkhau;
    private Date ngaybatdau;
    private Date ngayketthuc;
    private Date ngaytao;
    private Date ngaycapnhat;
    private Integer trangthai;
    private LoaiKhuyenMai loaiKhuyenMai;

    public KhuyenMai data(KhuyenMai khuyenMai){
        if (khuyenMai == null){
            khuyenMai = new KhuyenMai();
        }
        khuyenMai.setMakhuyenmai(this.getMakhuyenmai());
        khuyenMai.setTenkhuyenmai(this.getTenkhuyenmai());
        khuyenMai.setMota(this.getMota());
        khuyenMai.setChietkhau(this.getChietkhau());
        khuyenMai.setNgaybatdau(this.getNgaybatdau());
        khuyenMai.setNgayketthuc(this.getNgayketthuc());
        khuyenMai.setNgaytao(this.getNgaytao());
        khuyenMai.setNgaycapnhat(this.getNgaycapnhat());
        khuyenMai.setTrangthai(this.getTrangthai());
        khuyenMai.setLoaiKhuyenMai(this.getLoaiKhuyenMai());
        return khuyenMai;
    }
}
