package com.example.demo.bean;

import com.example.demo.entity.Anh;
import com.example.demo.entity.KichThuoc;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AnhForm {

    private UUID idimage;
    private String tenimage;
    private String imageurl1;
    private String imageurl2;
    private String imageurl3;
    private String imageurl4;

    public Anh data(Anh anh){
        if (anh == null){
            anh = new Anh();
        }
        anh.setIdimage(this.getIdimage());
        anh.setTenimage(this.getTenimage());
        anh.setImageurl1(this.getImageurl1());
        anh.setImageurl2(this.getImageurl2());
        anh.setImageurl3(this.getImageurl3());
        anh.setImageurl4(this.getImageurl4());
        return anh;
    }
}
