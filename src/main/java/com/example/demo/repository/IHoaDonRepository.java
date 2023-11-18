package com.example.demo.repository;


import com.example.demo.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IHoaDonRepository extends JpaRepository<HoaDon, String> {
}