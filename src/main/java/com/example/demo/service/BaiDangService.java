package com.example.demo.service;

import com.example.demo.entity.BaiDang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaiDangService {
    public Page<BaiDang> getAll(Integer pageNum , Integer pageSize);
    public List<BaiDang> count();
    public Optional<BaiDang> getById(UUID id);
    public BaiDang add(BaiDang chatLieu);
    public BaiDang update(BaiDang chatLieu);
    public BaiDang delete(BaiDang chatLieu);
    public BaiDang getByIdBD(UUID id);
}
