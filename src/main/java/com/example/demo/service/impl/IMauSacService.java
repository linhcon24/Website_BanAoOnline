package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IMauSacService implements MauSacService {

    @Autowired
    private MauSacRepository repository;

    @Override
    public Page<MauSac> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<MauSac> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<MauSac> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public MauSac add(MauSac mauSac) {
        return repository.save(mauSac);
    }

    @Override
    public MauSac update(MauSac mauSac) {
        MauSac ms = repository.getById(mauSac.getIdmausac());
        ms.setTenmausac(mauSac.getTenmausac());
        return repository.save(ms);
    }

    @Override
    public MauSac delete(MauSac mauSac) {
        MauSac ms = repository.getById(mauSac.getIdmausac());
        ms.setTrangthai(1);
        return repository.save(ms);
    }

    @Override
    public MauSac getByIdMS(Integer id) {
        return repository.getById(id);
    }
}
