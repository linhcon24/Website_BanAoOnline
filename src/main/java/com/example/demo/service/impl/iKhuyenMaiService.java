package com.example.demo.service.impl;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.entity.KichThuoc;
import com.example.demo.repository.KhuyenMaiRepository;
import com.example.demo.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class iKhuyenMaiService implements KhuyenMaiService {
    @Autowired
    private KhuyenMaiRepository repository;
    @Override
    public Page<KhuyenMai> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<KhuyenMai> getAll2() {
        return repository.findAll();
    }

    @Override
    public List<KhuyenMai> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<KhuyenMai> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public KhuyenMai add(KhuyenMai kichThuoc) {
        return repository.save(kichThuoc);
    }

    @Override
    public KhuyenMai update(KhuyenMai kichThuoc) {
        KhuyenMai kt = repository.getById(kichThuoc.getIdkhuyenmai());
        kt.setTenkhuyenmai(kt.getTenkhuyenmai());
        return repository.save(kt);
    }

    @Override
    public KhuyenMai delete(KhuyenMai kichThuoc) {
        KhuyenMai kt = repository.getById(kichThuoc.getIdkhuyenmai());
        kt.setTrangthai(1);
        return repository.save(kt);
    }

    @Override
    public KhuyenMai getByIdKM(Integer id) {
        return repository.getById(id);
    }
}
