package com.example.demo.service;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.MauSacViewModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MauSacService {

    public Page<MauSac> getAll(Integer pageNum , Integer pageSize);
    public List<MauSac> getAll2();
    public List<MauSac> count();
    public Optional<MauSac> getById(Integer id);
    public MauSac add(MauSac mauSac);
    public MauSac update(MauSac mauSac);
    public MauSac delete(MauSac mauSac);
    public MauSac getByIdMS(Integer id);
    public List<MauSacViewModel> getListMauSacBySP(Integer idSanPham);
}
