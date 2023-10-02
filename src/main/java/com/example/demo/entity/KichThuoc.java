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
@Table(name = "kichthuoc")
@ToString
public class KichThuoc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idkichthuoc;
    private String tenkichthuoc;
    private Date ngaytao;
    private Date ngaycapnhat;
    private Integer trangthai;

    @OneToMany(mappedBy = "kichThuoc" ,fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhams;
}

