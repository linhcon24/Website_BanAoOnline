package com.example.demo.viewmodel;

import com.example.demo.entity.ChiTietSanPham;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class HoaDonChiTietViewModel {
    private Integer soLuong;
    private ChiTietSanPham chiTietSanPham;
}