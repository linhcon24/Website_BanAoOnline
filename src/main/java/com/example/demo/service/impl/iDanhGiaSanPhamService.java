package com.example.demo.service.impl;

import com.example.demo.entity.DanhGiaSanPham;
import com.example.demo.entity.KichThuoc;
import com.example.demo.repository.DanhGiaSanPhamRepository;
import com.example.demo.repository.KichThuocRepository;
import com.example.demo.service.DanhGiaSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class iDanhGiaSanPhamService implements DanhGiaSanPhamService {
    @Autowired
    private DanhGiaSanPhamRepository repository;

    @Override
    public Page<DanhGiaSanPham> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<DanhGiaSanPham> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<DanhGiaSanPham> getById(String id) {
        return repository.findById(UUID.fromString(id));
    }

    @Override
    public DanhGiaSanPham add(DanhGiaSanPham dgsp) {
        return repository.save(dgsp);
    }

    @Override
    public DanhGiaSanPham update(DanhGiaSanPham dgsp) {
        DanhGiaSanPham danhGiaSanPham = repository.getById(dgsp.getIddanhgia());
        danhGiaSanPham.setSanPham(dgsp.getSanPham());
        danhGiaSanPham.setNoidung(dgsp.getNoidung());
        return repository.save(danhGiaSanPham);
    }

    @Override
    public DanhGiaSanPham delete(DanhGiaSanPham dgsp) {
        DanhGiaSanPham kt = repository.getById(dgsp.getIddanhgia());
        kt.setTrangthai(1);
        return repository.save(kt);
    }

    @Override
    public DanhGiaSanPham getByIdDGSP(String id) {
        return repository.getById(UUID.fromString(id));
    }
}
