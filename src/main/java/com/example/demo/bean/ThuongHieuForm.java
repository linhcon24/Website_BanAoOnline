package com.example.demo.bean;

import com.example.demo.entity.ThuongHieu;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ThuongHieuForm {

    private Integer idthuonghieu;
    private String tenthuonghieu;

    public ThuongHieu data(ThuongHieu thuongHieu){
        if (thuongHieu == null){
            thuongHieu = new ThuongHieu();
        }
        thuongHieu.setIdthuonghieu(this.getIdthuonghieu());
        thuongHieu.setTenthuonghieu(this.getTenthuonghieu());
        return thuongHieu;
    }

}
