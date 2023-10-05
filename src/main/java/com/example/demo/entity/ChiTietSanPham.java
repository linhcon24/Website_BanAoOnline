package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chitietsanpham")
public class ChiTietSanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idctsp;
    private BigDecimal gianhap;
    private BigDecimal giaban;
    private String mota;
    private Integer soluong;
    private Integer giamgia;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaycapnhat;
    private String nguoicapnhat;
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

    @OneToMany(mappedBy = "chiTietSanPham", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> gioHangChiTiets;

    @OneToMany(mappedBy = "chiTietSanPham", fetch = FetchType.LAZY)
    private List<ChiTietDonDatHang> chiTietDonDatHangs;


}
