package com.example.demo.service;

import com.example.demo.entity.KieuDang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface KieuDangService {
    public Page<KieuDang> getAll(Integer pageNum , Integer pageSize);
    public List<KieuDang> getAll2();
    public List<KieuDang> count();
    public Optional<KieuDang> getById(Integer id);
    public KieuDang add(KieuDang kieuDang);
    public KieuDang update(KieuDang kieuDang);
    public KieuDang delete(KieuDang kieuDang);
    public KieuDang getByIdKD(Integer id);
}
