package com.example.demo.service;

import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SanPhamService {

    public Page<SanPham> getAll(Integer pageNum , Integer pageSize);
    public List<SanPham> getAll2();
    public List<SanPham> count();
    public Optional<SanPham> getById(Integer id);
    public SanPham add(SanPham sanPham);
    public SanPham update(SanPham sanPham);
    public SanPham delete(SanPham sanPham);
    public SanPham getByIdSP(Integer id);
    public String generateNextProductCode();
}
