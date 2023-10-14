package com.example.demo.service;

import com.example.demo.entity.GioHangChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GioHangChiTietService {

    public Page<GioHangChiTiet> getAll(Integer pageNum , Integer pageSize, Integer idTaiKhoan);
    public List<GioHangChiTiet> count(Integer idTaiKhoan);
    public GioHangChiTiet add(GioHangChiTiet gioHangChiTiet);
    public GioHangChiTiet update(GioHangChiTiet gioHangChiTiet);
    public GioHangChiTiet delete(GioHangChiTiet gioHangChiTiet);
    public GioHangChiTiet getByIdGHCT(UUID id);
    public Double getTotalMoney(List<GioHangChiTiet> listGHCT);
    public Integer getTotalProduct(List<GioHangChiTiet> listGHCT);
}
