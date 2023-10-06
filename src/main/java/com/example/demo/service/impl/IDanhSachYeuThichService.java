package com.example.demo.service.impl;

import com.example.demo.entity.DanhSachYeuThich;
import com.example.demo.repository.DanhSachYeuThichRepository;
import com.example.demo.service.DanhSachYeuThichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IDanhSachYeuThichService implements DanhSachYeuThichService {
    @Autowired
    private DanhSachYeuThichRepository repository;

    @Override
    public Page<DanhSachYeuThich> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<DanhSachYeuThich> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<DanhSachYeuThich> getById(UUID id) {
        return repository.findById(id);
    }

}
