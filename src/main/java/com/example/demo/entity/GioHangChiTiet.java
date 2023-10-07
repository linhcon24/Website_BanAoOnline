package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "giohangchitiet")
@ToString
public class GioHangChiTiet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idgiohangchitiet;
    private Integer soluong;
    private Double dongia;

    @ManyToOne
    @JoinColumn(name = "idgiohang")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "idctsp")
    private ChiTietSanPham chiTietSanPham;

}
