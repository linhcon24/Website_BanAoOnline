package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anh")
@ToString
public class Anh implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idimage;
    private String tenimage;
    private String imageurl1;
    private String imageurl2;
    private String imageurl3;
    private String imageurl4;
    private Date ngaytao;
    private Date ngaycapnhat;
    private Integer trangthai;

    @OneToMany(mappedBy = "anh", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhams;
}

