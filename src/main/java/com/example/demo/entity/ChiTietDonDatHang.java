package com.example.demo.entity;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chitietdondathang")
@ToString
public class ChiTietDonDatHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idchitietdondathang;
    private Double dongia;
    private Integer soluong;
    private Double giatien;
    private Double giagiam;
    private String ghichu;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaycapnhat;
    private String nguoicapnhat;
    private Integer trangthai;

    @ManyToOne
    @JoinColumn(name = "iddondathang")
    private DonDatHang donDatHang;

    @ManyToOne
    @JoinColumn(name = "idctsp")
    private ChiTietSanPham chiTietSanPham;



}
