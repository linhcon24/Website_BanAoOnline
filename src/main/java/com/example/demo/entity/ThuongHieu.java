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
@Table(name = "thuonghieu")
@ToString
public class ThuongHieu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idthuonghieu;
    private String tenthuonghieu;
    private Date ngaytao;
    private Date ngaycapnhat;
    private Integer trangthai;
}
