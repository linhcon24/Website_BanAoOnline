package com.example.demo.service;

import com.example.demo.entity.Anh;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AnhService {
    public Page<Anh> getAll(Integer pageNum , Integer pageSize);
    public List<Anh> count();
    public Optional<Anh> getById(Integer id);
    public Anh add(Anh anh);
    public Anh update(Anh anh);
    public Anh delete(Anh anh);
    public Anh getByIdA(Integer id);
}
