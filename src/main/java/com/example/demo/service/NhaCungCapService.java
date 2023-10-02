package com.example.demo.service;

import com.example.demo.entity.NhaCungCap;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface NhaCungCapService {

    public Page<NhaCungCap> getAll(Integer pageNum , Integer pageSize);
    public List<NhaCungCap> count();
    public Optional<NhaCungCap> getById(Integer id);
    public NhaCungCap add(NhaCungCap nhaCungCap);
    public NhaCungCap update(NhaCungCap nhaCungCap);
    public NhaCungCap delete(NhaCungCap nhaCungCap);
    public NhaCungCap getByIdNCC(Integer id);
}
