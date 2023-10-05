package com.example.demo.bean;

import com.example.demo.entity.MauSac;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MauSacForm {
    private Integer idmausac;
    private String tenmausac;

    public MauSac data(MauSac mauSac){
        if (mauSac == null){
            mauSac = new MauSac();
        }
        mauSac.setIdmausac(this.getIdmausac());
        mauSac.setTenmausac(this.getTenmausac());
        return mauSac;
    }
}
