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
@Table(name = "baidang")
@ToString
public class BaiDang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idbaidang;
    private String mabaidang;
    private String tenbaidang;
    private String noidung;
    private Timestamp ngaytao;
    private Timestamp ngaycapnhat;
    private Integer trangthai;

    @ManyToOne
    @JoinColumn(name = "idtaikhoan")
    private TaiKhoan taiKhoan;
}
