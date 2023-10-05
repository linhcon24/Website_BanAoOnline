package com.example.demo.service;

import com.example.demo.entity.TaiKhoan;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TaiKhoanService {

     List<TaiKhoan> getAll();
     Page<TaiKhoan> getAll(Integer pageNum , Integer pageSize);
     List<TaiKhoan> count();
     Optional<TaiKhoan> getById(Integer id);
     TaiKhoan add(TaiKhoan taiKhoan);
     TaiKhoan update(TaiKhoan taiKhoan);
     TaiKhoan delete(TaiKhoan taiKhoan);
     TaiKhoan getAccountById(Integer id);
     TaiKhoan getByUsername(String username);
//    public TaiKhoan authention(String username , String password);
}
