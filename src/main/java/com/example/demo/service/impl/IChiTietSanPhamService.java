package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IChiTietSanPhamService implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository repository;

    @Override
    public Page<ChiTietSanPham> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<ChiTietSanPham> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<ChiTietSanPham> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public ChiTietSanPham add(ChiTietSanPham chiTietSanPham) {
        return repository.save(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham update(ChiTietSanPham chiTietSanPham) {
        ChiTietSanPham ctsp = repository.getById(chiTietSanPham.getIdctsp());
        //Chua update

        return repository.save(ctsp);
    }

    @Override
    public ChiTietSanPham delete(ChiTietSanPham chiTietSanPham) {
        ChiTietSanPham ctsp = repository.getById(chiTietSanPham.getIdctsp());
        ctsp.setTrangthai(1);
        return repository.save(ctsp);
    }

    @Override
    public ChiTietSanPham getByIdCTSP(Integer id) {
        return repository.getById(id);
    }

    @Override
    public List<ChiTietSanPham> getListByIdSanPham(Integer idSanPham) {
        return repository.getListByIdSanPham(idSanPham);
    }

//    @Override
//    public List<ChiTietSanPham> getListSPByMSandKT(Integer idSanPham, Integer idMauSac, Integer idKichThuoc) {
//        return repository.getListSPByMSandKT(idSanPham, idMauSac, idKichThuoc);
//    }


}
