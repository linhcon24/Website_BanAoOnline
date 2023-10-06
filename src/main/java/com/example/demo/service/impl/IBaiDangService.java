package com.example.demo.service.impl;

import com.example.demo.entity.BaiDang;
import com.example.demo.repository.BaiDangRepository;
import com.example.demo.service.BaiDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class IBaiDangService implements BaiDangService {

    @Autowired
    private BaiDangRepository repository;

    @Override
    public Page<BaiDang> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<BaiDang> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<BaiDang> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public BaiDang add(BaiDang chatLieu) {
        return repository.save(chatLieu);
    }

    @Override
    public BaiDang update(BaiDang chatLieu) {
        BaiDang cl = repository.getById(chatLieu.getIdbaidang());
        cl.setTenbaidang(chatLieu.getTenbaidang());
        return repository.save(cl);
    }

    @Override
    public BaiDang delete(BaiDang chatLieu) {
        BaiDang cl = repository.getById(chatLieu.getIdbaidang());
        cl.setTrangthai(1);
        return repository.save(cl);
    }

    @Override
    public BaiDang getByIdBD(UUID id) {
        return repository.getById(id);
    }
}
