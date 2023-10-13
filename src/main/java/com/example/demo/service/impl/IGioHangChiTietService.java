package com.example.demo.service.impl;

import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.repository.GioHangChiTietRepository;
import com.example.demo.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IGioHangChiTietService implements GioHangChiTietService {

    @Autowired
    private GioHangChiTietRepository repository;

    @Override
    public Page<GioHangChiTiet> getAll(Integer pageNum, Integer pageSize, Integer idTaiKhoan) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable, idTaiKhoan);
    }

    @Override
    public List<GioHangChiTiet> count(Integer idTaiKhoan) {
        return repository.countPhanTrang(idTaiKhoan);
    }

    @Override
    public GioHangChiTiet add (GioHangChiTiet gioHangChiTiet) {
        return repository.save(gioHangChiTiet);
    }

    @Override
    public GioHangChiTiet update(GioHangChiTiet gioHangChiTiet) {
        GioHangChiTiet ghct = repository.getById(gioHangChiTiet.getIdgiohangchitiet());
        gioHangChiTiet.setSoluong(ghct.getSoluong());
        return repository.save(ghct);
    }

    @Override
    public GioHangChiTiet delete(GioHangChiTiet gioHangChiTiet) {
        GioHangChiTiet ghct = repository.getById(gioHangChiTiet.getIdgiohangchitiet());
//        kt.setTrangthai(1);
        return repository.save(ghct);
    }

    @Override
    public GioHangChiTiet getByIdGHCT(UUID id) {
        return repository.getById(id);
    }

    @Override
    public Double getTotalMoney(List<GioHangChiTiet> listGHCT) {
        Double totalMoney = 0.0;
        for (GioHangChiTiet o : listGHCT){
            totalMoney+= o.getDongia() * o.getSoluong();
        }
        return totalMoney;
    }

}
