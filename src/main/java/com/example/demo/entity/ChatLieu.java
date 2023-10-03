package com.example.demo.entity;

import lombok.*;

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
@Table(name = "chatlieu")
@ToString
public class ChatLieu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idchatlieu;
    private String tenchatlieu;
    private Timestamp ngaytao;
    private Timestamp ngaycapnhat;
    private Integer trangthai;

    @OneToMany(mappedBy = "chatLieu", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhams;
}
