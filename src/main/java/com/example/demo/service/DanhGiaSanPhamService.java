package com.example.demo.service;


import com.example.demo.entity.DanhGiaSanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DanhGiaSanPhamService {
    Page<DanhGiaSanPham> getAll(Integer pageNum, Integer pageSize);

    List<DanhGiaSanPham> count();

    Optional<DanhGiaSanPham> getById(String id);

    DanhGiaSanPham add(DanhGiaSanPham dgsp);

    DanhGiaSanPham update(DanhGiaSanPham dgsp);

    DanhGiaSanPham delete(DanhGiaSanPham dgsp);

    DanhGiaSanPham getByIdDGSP(String id);
}
