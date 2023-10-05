package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaycapnhat;
    private String nguoicapnhat;
    private Integer trangthai;

    @OneToMany(mappedBy = "kichThuoc" ,fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhams;
}

