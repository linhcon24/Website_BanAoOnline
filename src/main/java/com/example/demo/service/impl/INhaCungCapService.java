package com.example.demo.service.impl;

import com.example.demo.entity.NhaCungCap;
import com.example.demo.repository.NhaCungCapRepository;
import com.example.demo.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class INhaCungCapService implements NhaCungCapService {

    @Autowired
    private NhaCungCapRepository repository;

    @Override
    public Page<NhaCungCap> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<NhaCungCap> getAll2() {
        return repository.findAll();
    }

    @Override
    public List<NhaCungCap> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<NhaCungCap> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public NhaCungCap add(NhaCungCap nhaCungCap) {
        return repository.save(nhaCungCap);
    }

    @Override
    public NhaCungCap update(NhaCungCap nhaCungCap) {
        NhaCungCap ncc = repository.getById(nhaCungCap.getIdnhacungcap());
        ncc.setTennhacungcap(nhaCungCap.getTennhacungcap());
        return repository.save(ncc);
    }

    @Override
    public NhaCungCap delete(NhaCungCap nhaCungCap) {
        NhaCungCap ncc = repository.getById(nhaCungCap.getIdnhacungcap());
        ncc.setTrangthai(1);
        return repository.save(ncc);
    }

    @Override
    public NhaCungCap getByIdNCC(Integer id) {
        return repository.getById(id);
    }
}
