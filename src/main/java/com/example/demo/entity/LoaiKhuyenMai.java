package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loaikhuyenmai")
@ToString
public class LoaiKhuyenMai implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idloaikhuyenmai;
    private String maloaikhuyenmai;
    private String tenloaikhuyenmai;
    private Date ngaytao;
    private Date ngaycapnhat;
    private Integer trangthai;

    @OneToMany(mappedBy = "loaiKhuyenMai", fetch = FetchType.LAZY)
    private List<KhuyenMai> khuyenMais;
}
