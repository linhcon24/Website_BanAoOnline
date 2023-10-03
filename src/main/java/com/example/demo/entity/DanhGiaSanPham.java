package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "danhgiasanpham")
@ToString
public class DanhGiaSanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID iddanhgia;
    private String madanhgia;
    private String noidung;
    private Timestamp ngaytao;
    private Timestamp ngaycapnhat;
    private Integer trangthai;

    @ManyToOne
    @JoinColumn(name = "idsanpham")
    private SanPham sanPham;


}
