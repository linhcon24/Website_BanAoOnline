package com.example.demo.service.impl;

import com.example.demo.entity.LoaiKhuyenMai;
import com.example.demo.repository.LoaiKhuyenMaiRepository;
import com.example.demo.service.LoaiKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class iLoaiKhuyenMaiService implements LoaiKhuyenMaiService {
    @Autowired
    LoaiKhuyenMaiRepository repository;


    @Override
    public Page<LoaiKhuyenMai> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<LoaiKhuyenMai> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<LoaiKhuyenMai> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public LoaiKhuyenMai add(LoaiKhuyenMai loaiKhuyenMai) {
        return repository.save(loaiKhuyenMai);
    }

    @Override
    public LoaiKhuyenMai update(LoaiKhuyenMai loaiKhuyenMai) {
        LoaiKhuyenMai ms = repository.getById(loaiKhuyenMai.getIdloaikhuyenmai());
        ms.setTenloaikhuyenmai(loaiKhuyenMai.getTenloaikhuyenmai());
        return repository.save(ms);
    }

    @Override
    public LoaiKhuyenMai delete(LoaiKhuyenMai loaiKhuyenMai) {
        LoaiKhuyenMai ms = repository.getById(loaiKhuyenMai.getIdloaikhuyenmai());
        ms.setTrangthai(1);
        return repository.save(ms);
    }

    @Override
    public LoaiKhuyenMai getByIdLKM(Integer id) {
        return repository.getById(id);
    }
}
