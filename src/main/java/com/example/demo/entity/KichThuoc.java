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
@Table(name = "kichthuoc")
@ToString
public class KichThuoc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKichThuoc;
    private String tenKichThuoc;
    private Date ngayTao;
    private Date ngayCapNhat;
    private Integer trangThai;
}

