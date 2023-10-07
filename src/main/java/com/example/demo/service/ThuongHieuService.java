package com.example.demo.service;

import com.example.demo.entity.ThuongHieu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ThuongHieuService {

    public Page<ThuongHieu> getAll(Integer pageNum , Integer pageSize);
    public List<ThuongHieu> getAll2();
    public List<ThuongHieu> count();
    public Optional<ThuongHieu> getById(Integer id);
    public ThuongHieu add(ThuongHieu thuongHieu);
    public ThuongHieu update(ThuongHieu thuongHieu);
    public ThuongHieu delete(ThuongHieu thuongHieu);
    public ThuongHieu getByIdTH(Integer id);
}
