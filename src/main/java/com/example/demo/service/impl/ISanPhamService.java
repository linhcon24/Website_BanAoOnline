package com.example.demo.service.impl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ISanPhamService implements SanPhamService {

    @Autowired
    private SanPhamRepository repository;

    @Override
    public Page<SanPham> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<SanPham> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<SanPham> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public SanPham add(SanPham sanPham) {
        return repository.save(sanPham);
    }

    @Override
    public SanPham update(SanPham sanPham) {
        SanPham sp = repository.getById(sanPham.getIdsanpham());
        sp.setTensanpham(sanPham.getTensanpham());
        return repository.save(sp);
    }

    @Override
    public SanPham delete(SanPham sanPham) {
        SanPham sp = repository.getById(sanPham.getIdsanpham());
        sp.setTrangthai(1);
        return repository.save(sp);
    }

    @Override
    public SanPham getByIdSP(Integer id) {
        return repository.getById(id);
    }
}
