package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khuyenmai")
@ToString
public class KhuyenMai implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idkhuyenmai;
    private String makhuyenmai;
    private String tenkhuyenmai;
    private String mota;
    private Integer chietkhau;
    private Timestamp ngaybatdau;
    private Timestamp ngayketthuc;
    private Timestamp ngaytao;
    private Timestamp ngaycapnhat;
    private Integer trangthai;

    @OneToMany(mappedBy = "khuyenMai" ,fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhams;

    @ManyToOne
    @JoinColumn(name = "idloaikhuyenmai")
    private LoaiKhuyenMai loaiKhuyenMai;


}
