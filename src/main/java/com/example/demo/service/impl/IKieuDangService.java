package com.example.demo.service.impl;

import com.example.demo.entity.KieuDang;
import com.example.demo.repository.KieuDangRepository;
import com.example.demo.service.KieuDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IKieuDangService implements KieuDangService {

    @Autowired
    private KieuDangRepository repository;

    @Override
    public Page<KieuDang> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<KieuDang> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<KieuDang> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public KieuDang add(KieuDang kieuDang) {
        return repository.save(kieuDang);
    }

    @Override
    public KieuDang update(KieuDang kieuDang) {
        KieuDang kd = repository.getById(kieuDang.getIdKieuDang());
        kd.setTenKieuDang(kieuDang.getTenKieuDang());
        return repository.save(kd);
    }

    @Override
    public KieuDang delete(KieuDang kieuDang) {
        KieuDang kd = repository.getById(kieuDang.getIdKieuDang());
        kd.setTrangThai(1);
        return repository.save(kd);
    }

    @Override
    public KieuDang getByIdKD(Integer id) {
        return repository.getById(id);
    }
}
