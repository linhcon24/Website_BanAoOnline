package com.example.demo.service.impl;

import com.example.demo.entity.KichThuoc;
import com.example.demo.repository.KichThuocRepository;
import com.example.demo.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IKichThuocService implements KichThuocService {

    @Autowired
    private KichThuocRepository repository;

    @Override
    public Page<KichThuoc> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<KichThuoc> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<KichThuoc> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public KichThuoc add(KichThuoc kichThuoc) {
        return repository.save(kichThuoc);
    }

    @Override
    public KichThuoc update(KichThuoc kichThuoc) {
        KichThuoc kt = repository.getById(kichThuoc.getIdKichThuoc());
        kt.setTenKichThuoc(kt.getTenKichThuoc());
        return repository.save(kt);
    }

    @Override
    public KichThuoc delete(KichThuoc kichThuoc) {
        KichThuoc kt = repository.getById(kichThuoc.getIdKichThuoc());
        kt.setTrangThai(1);
        return repository.save(kt);
    }

    @Override
    public KichThuoc getByIdKT(Integer id) {
        return repository.getById(id);
    }
}
