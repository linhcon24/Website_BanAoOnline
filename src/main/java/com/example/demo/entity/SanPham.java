package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sanpham")
@ToString
public class SanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSanPham;
    private String maSanPham;
    private String tenSanPham;
    private Date ngayTao;
    private Date ngayCapNhat;
    private Integer trangThai;
}

