package com.example.demo.service;

import com.example.demo.entity.KhuyenMai;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KhuyenMaiService {
    Page<KhuyenMai> getAll(Integer pageNum, Integer pageSize);

    List<KhuyenMai> count();

    Optional<KhuyenMai> getById(Integer id);

    KhuyenMai add(KhuyenMai khuyenMai);

    KhuyenMai update(KhuyenMai khuyenMai);

    KhuyenMai delete(KhuyenMai khuyenMai);

    KhuyenMai getByIdKM(Integer id);
}
