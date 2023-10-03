package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaycapnhat;
    private Integer trangthai;

    @ManyToOne
    @JoinColumn(name = "idsanpham")
    private SanPham sanPham;


}
