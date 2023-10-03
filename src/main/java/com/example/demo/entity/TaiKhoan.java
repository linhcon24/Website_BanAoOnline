package com.example.demo.entity;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taikhoan")
@ToString
public class TaiKhoan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idtaikhoan;
    private String tentaikhoan;
    private String username;
    private String password;
    private String image;
    private String email;
    private String sdt;
    private Boolean gioitinh;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaycapnhat;
    private Integer trangthai;

    @OneToMany(mappedBy = "taiKhoan", fetch = FetchType.LAZY)
    private List<DonDatHang> donDatHangs;

    @OneToMany(mappedBy = "taiKhoan", fetch = FetchType.LAZY)
    private List<BaiDang> baiDangs;

    @OneToMany(mappedBy = "taiKhoan", fetch = FetchType.LAZY)
    private List<DanhSachYeuThich> danhSachYeuThiches;

    @OneToMany(mappedBy = "taiKhoan", fetch = FetchType.LAZY)
    private List<Authority> authorities;

    @OneToMany(mappedBy = "taiKhoan", fetch = FetchType.LAZY)
    private List<GioHang> gioHangs;

}
