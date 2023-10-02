package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID idAnh;
    private String tenAnh;
    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private Date ngayTao;
    private Date ngayCapNhat;
    private Integer trangThai;
}

