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
@Table(name = "nhacungcap")
@ToString
public class NhaCungCap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNhaCungCap;
    private String tenNhaCungCap;
    private Date ngayTao;
    private Date ngayCapNhat;
    private Integer trangThai;
}


