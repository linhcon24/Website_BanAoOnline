package com.example.demo.bean;


import com.example.demo.entity.NhaCungCap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NhaCungCapForm {
    private Integer idnhacungcap;
    private String tennhacungcap;

    public NhaCungCap data(NhaCungCap nhaCungCap){
        if (nhaCungCap == null){
            nhaCungCap = new NhaCungCap();
        }
        nhaCungCap.setIdnhacungcap(this.getIdnhacungcap());
        nhaCungCap.setTennhacungcap(this.getTennhacungcap());
        return nhaCungCap;
    }
}
