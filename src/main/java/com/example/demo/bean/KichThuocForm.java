package com.example.demo.bean;

import com.example.demo.entity.KichThuoc;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KichThuocForm {

    private Integer idkichthuoc;
    private String tenkichthuoc;

    public KichThuoc data(KichThuoc kichThuoc){
        if (kichThuoc == null){
            kichThuoc = new KichThuoc();
        }
        kichThuoc.setIdkichthuoc(this.getIdkichthuoc());
        kichThuoc.setTenkichthuoc(this.getTenkichthuoc());
        return kichThuoc;
    }
}
