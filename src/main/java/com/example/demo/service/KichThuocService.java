package com.example.demo.service;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.KichThuocViewModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface KichThuocService {
    public Page<KichThuoc> getAll(Integer pageNum , Integer pageSize);
    public List<KichThuoc> getAll2();
    public List<KichThuoc> count();
    public Optional<KichThuoc> getById(Integer id);
    public KichThuoc add(KichThuoc kichThuoc);
    public KichThuoc update(KichThuoc kichThuoc);
    public KichThuoc delete(KichThuoc kichThuoc);
    public KichThuoc getByIdKT(Integer id);
    public List<KichThuocViewModel> getListKichThuocBySP(Integer idSanPham);
}
