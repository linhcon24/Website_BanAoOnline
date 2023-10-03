package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "danhsachyeuthich")
@ToString
public class DanhSachYeuThich implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID iddanhsachyt;
    private String madanhsachyt;
    private String tendanhsachyt;
    private Timestamp ngaytao;
    private Timestamp ngaycapnhat;
    private Integer trangthai;

    @ManyToOne
    @JoinColumn(name = "idtaikhoan")
    private TaiKhoan taiKhoan;
}
