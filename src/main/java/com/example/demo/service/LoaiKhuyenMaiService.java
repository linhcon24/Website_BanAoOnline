package com.example.demo.service;

import com.example.demo.entity.LoaiKhuyenMai;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface LoaiKhuyenMaiService {

    Page<LoaiKhuyenMai> getAll(Integer pageNum, Integer pageSize);

    List<LoaiKhuyenMai> count();

    Optional<LoaiKhuyenMai> getById(Integer id);

    LoaiKhuyenMai add(LoaiKhuyenMai mauSac);

    LoaiKhuyenMai update(LoaiKhuyenMai mauSac);

    LoaiKhuyenMai delete(LoaiKhuyenMai mauSac);

    LoaiKhuyenMai getByIdLKM(Integer id);
}
