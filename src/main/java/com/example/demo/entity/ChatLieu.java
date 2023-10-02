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
@Table(name = "chatlieu")
@ToString
public class ChatLieu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChatLieu;
    private String tenChatLieu;
    private Date ngayTao;
    private Date ngayCapNhat;
    private Integer trangThai;
}
