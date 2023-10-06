package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Date ngaybatdau;
    private Date ngayketthuc;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaycapnhat;
    private String nguoicapnhat;
    private Integer trangthai;

//    @OneToMany(mappedBy = "khuyenMai" ,fetch = FetchType.LAZY)
//    private List<ChiTietSanPham> chiTietSanPhams;

    @ManyToOne
    @JoinColumn(name = "idloaikhuyenmai")
    private LoaiKhuyenMai loaiKhuyenMai;


}
