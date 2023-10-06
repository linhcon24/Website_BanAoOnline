package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaycapnhat;
    private String nguoicapnhat;
    private Integer trangthai;

//    @OneToMany(mappedBy = "anh", fetch = FetchType.LAZY)
//    private List<ChiTietSanPham> chiTietSanPhams;
}

