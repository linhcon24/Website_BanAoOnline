package com.example.demo.service.impl;

import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;
import com.example.demo.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ITaiKhoanService implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository repository;

    @Override
    public List<TaiKhoan> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<TaiKhoan> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum , pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<TaiKhoan> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<TaiKhoan> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public TaiKhoan add(TaiKhoan taiKhoan) {
        taiKhoan.setNgaytao(new Date());
        taiKhoan.setNguoicapnhat("Linh Create");
        return repository.save(taiKhoan);
    }

    @Override
    public TaiKhoan update(TaiKhoan taiKhoan) {
        TaiKhoan tk = repository.getById(taiKhoan.getIdtaikhoan());
//        tk.setUsername(taiKhoan.getUsername());
        tk.setPassword(taiKhoan.getPassword());
        tk.setEmail(taiKhoan.getEmail());
        tk.setImage(taiKhoan.getImage());
        tk.setSdt(taiKhoan.getSdt());
        tk.setGioitinh(taiKhoan.getGioitinh());
        tk.setVaitro(taiKhoan.getVaitro());
        tk.setNgaycapnhat(new Date());
        tk.setNguoicapnhat("Linh Update");
        return repository.save(tk);
    }

    @Override
    public TaiKhoan delete(TaiKhoan taiKhoan) {
        TaiKhoan taiKhoan1 = repository.getById(taiKhoan.getIdtaikhoan());
        taiKhoan1.setTrangthai(1);
        return repository.save(taiKhoan1);
    }

    @Override
    public TaiKhoan getAccountById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public TaiKhoan getByUsername(String username) {
        return repository.getByUsername(username);
    }

}
