package com.example.demo.service.impl;

import com.example.demo.entity.Anh;
import com.example.demo.repository.AnhRepository;
import com.example.demo.service.AnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IAnhService implements AnhService {

    @Autowired
    private AnhRepository repository;

    @Override
    public Page<Anh> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<Anh> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<Anh> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Anh add(Anh anh) {
        return repository.save(anh);
    }

    @Override
    public Anh update(Anh anh) {
        Anh a = repository.getById(anh.getIdimage());
        a.setIdimage(a.getIdimage());
        return repository.save(a);
    }

    @Override
    public Anh delete(Anh anh) {
        Anh a = repository.getById(anh.getIdimage());
        a.setTrangthai(1);
        return repository.save(a);
    }

    @Override
    public Anh getByIdA(UUID id) {
        return repository.getById(id);
    }
}
