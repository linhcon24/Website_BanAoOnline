package com.example.demo.bean;

import com.example.demo.entity.TaiKhoan;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThongTinForm {

    private String anh;
    private String username;
    private String password;
    private String email;
    private String sdt;

    public TaiKhoan data(TaiKhoan thongTin){
        if (thongTin == null){
            thongTin = new TaiKhoan();
        }
        thongTin.setUsername(this.getUsername());
        thongTin.setPassword(this.getPassword());
        thongTin.setEmail(this.getEmail());
        thongTin.setImage(this.getAnh());
        thongTin.setSdt(this.getSdt());
        return thongTin;
    }

}
