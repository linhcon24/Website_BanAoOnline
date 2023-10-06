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
@Table(name = "thuonghieu")
@ToString
public class ThuongHieu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idthuonghieu;
    private String tenthuonghieu;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaycapnhat;
    private String nguoicapnhat;
    private Integer trangthai;

//    @OneToMany(mappedBy = "thuongHieu",fetch = FetchType.LAZY)
//    private List<ChiTietSanPham> chiTietSanPhams;
}
