package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dondathang")
@ToString
public class DonDatHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddondathang;
    private String madondathang;
    private String sdtnhan;
    private String diachinhan;
    private String nguoinhan;
    private Double phiship;
    private Double tongtien;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaycapnhat;
    private String nguoicapnhat;
    private Integer trangthai;

    @ManyToOne
    @JoinColumn(name = "idtaikhoan")
    private TaiKhoan taiKhoan;

    @ManyToOne
    @JoinColumn(name = "idphuongthucthanhtoan")
    private PhuongThucThanhToan phuongThucThanhToan;

    @ManyToOne
    @JoinColumn(name = "idhoadon")
    private HoaDon hoaDon;

    @OneToMany(mappedBy = "donDatHang", fetch = FetchType.LAZY)
    private List<ChiTietDonDatHang> chiTietDonDatHangs;

}
