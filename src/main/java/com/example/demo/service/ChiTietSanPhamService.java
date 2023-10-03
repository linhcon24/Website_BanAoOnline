package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietSanPhamService {

    public Page<ChiTietSanPham> getAll(Integer pageNum , Integer pageSize);
    public List<ChiTietSanPham> count();
    public Optional<ChiTietSanPham> getById(UUID id);
    public ChiTietSanPham add(ChiTietSanPham chiTietSanPham);
    public ChiTietSanPham update(ChiTietSanPham chiTietSanPham);
    public ChiTietSanPham delete(ChiTietSanPham chiTietSanPham);
    public ChiTietSanPham getByIdCTSP(UUID id);
}
