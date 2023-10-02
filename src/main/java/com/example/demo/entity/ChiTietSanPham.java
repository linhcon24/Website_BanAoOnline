package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chitietsanpham")
@ToString
public class ChiTietSanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idctsp;
    private BigDecimal gianhap;
    private BigDecimal giaban;
    private String mota;
    private Integer soluong;
    private Integer giamgia;
    private Date ngaytao;
    private Date ngaycapnhat;
    private Integer trangthai;

    @ManyToOne
    @JoinColumn(name = "idsanpham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "idthuonghieu")
    private ThuongHieu thuongHieu;

    @ManyToOne
    @JoinColumn(name = "idnhacungcap")
    private NhaCungCap nhaCungCap;

    @ManyToOne
    @JoinColumn(name = "idkieudang")
    private KieuDang kieuDang;

    @ManyToOne
    @JoinColumn(name = "idkichthuoc")
    private KichThuoc kichThuoc;

    @ManyToOne
    @JoinColumn(name = "idchatlieu")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "idmausac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "idkhuyenmai")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @JoinColumn(name = "idimage")
    private Anh anh;




}
