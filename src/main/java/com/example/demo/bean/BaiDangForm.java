package com.example.demo.bean;

import com.example.demo.entity.BaiDang;
import com.example.demo.entity.TaiKhoan;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;
@Getter
@Setter
public class BaiDangForm {
    private UUID idbaidang;
    private String mabaidang;
    private String tenbaidang;
    private String noidung;
    private Date ngaytao;
    private Date ngaycapnhat;
    private String nguoicapnhat;
    private Integer trangthai;
    private TaiKhoan taiKhoan;

    public BaiDang data(BaiDang baiDang){
        if (baiDang == null){
            baiDang = new BaiDang();
        }
        baiDang.setMabaidang(this.getMabaidang());
        baiDang.setTenbaidang(this.getTenbaidang());
        baiDang.setNoidung(this.getNoidung());
        baiDang.setNgaytao(this.getNgaytao());
        baiDang.setNgaycapnhat(this.getNgaycapnhat());
        baiDang.setNguoicapnhat(this.getNguoicapnhat());
        baiDang.setTrangthai(this.getTrangthai());
        baiDang.setTaiKhoan(this.getTaiKhoan());
        return baiDang;
    }
}
