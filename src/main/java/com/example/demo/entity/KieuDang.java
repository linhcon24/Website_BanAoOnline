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
@Table(name = "kieudang")
@ToString
public class KieuDang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKieuDang;
    private String tenKieuDang;
    private Date ngayTao;
    private Date ngayCapNhat;
    private Integer trangThai;
}


