package com.example.demo.service;

import com.example.demo.entity.DanhSachYeuThich;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DanhSachYeuThichService {
    Page<DanhSachYeuThich> getAll(Integer pageNum , Integer pageSize);
    List<DanhSachYeuThich> count();
    Optional<DanhSachYeuThich> getById(UUID id);
}
