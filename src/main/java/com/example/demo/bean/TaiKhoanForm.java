package com.example.demo.bean;

import com.example.demo.entity.TaiKhoan;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaiKhoanForm {

    private Integer idtaikhoan;
    private String username;
    private String password;
    private Boolean gioitinh;
    private String email;
    private String image;
    private String sdt;
    private Integer vaitro;

    public TaiKhoan data(TaiKhoan taiKhoan){
        if (taiKhoan == null){
            taiKhoan = new TaiKhoan();
        }
        taiKhoan.setIdtaikhoan(this.getIdtaikhoan());
        taiKhoan.setUsername(this.getUsername());
        taiKhoan.setPassword(this.getPassword());
        taiKhoan.setGioitinh(this.getGioitinh());
        taiKhoan.setEmail(this.getEmail());
        taiKhoan.setImage(this.getImage());
        taiKhoan.setSdt(this.getSdt());
        taiKhoan.setVaitro(this.getVaitro());
        return taiKhoan;
    }
}
