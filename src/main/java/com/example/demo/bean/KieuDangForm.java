package com.example.demo.bean;

import com.example.demo.entity.KieuDang;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KieuDangForm {
    private Integer idkieudang;
    private String tenkieudang;

    public KieuDang data(KieuDang kieuDang){
        if (kieuDang == null){
            kieuDang = new KieuDang();
        }
        kieuDang.setIdkieudang(this.getIdkieudang());
        kieuDang.setTenkieudang(this.getTenkieudang());
        return kieuDang;
    }
}
