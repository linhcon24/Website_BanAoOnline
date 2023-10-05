package com.example.demo.service.impl;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.ThuongHieuRepository;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IThuongHieuService implements ThuongHieuService {

    @Autowired
    private ThuongHieuRepository repository;

    @Override
    public Page<ThuongHieu> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<ThuongHieu> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<ThuongHieu> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public ThuongHieu add(ThuongHieu thuongHieu) {
        thuongHieu.setNgaytao(new Date());
        thuongHieu.setNgaycapnhat(new Date());
        return repository.save(thuongHieu);
    }

    @Override
    public ThuongHieu update(ThuongHieu thuongHieu) {
        ThuongHieu th = repository.getById(thuongHieu.getIdthuonghieu());
        th.setTenthuonghieu(thuongHieu.getTenthuonghieu());
        thuongHieu.setNgaytao(new Date());
        thuongHieu.setNgaycapnhat(new Date());
        return repository.save(th);
    }

    @Override
    public ThuongHieu delete(ThuongHieu thuongHieu) {
        ThuongHieu th = repository.getById(thuongHieu.getIdthuonghieu());
        th.setTrangthai(1);
        return repository.save(th);
    }

    @Override
    public ThuongHieu getByIdTH(Integer id) {
        return repository.getById(id);
    }
}
