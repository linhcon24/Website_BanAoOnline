package com.example.demo.repository;

import com.example.demo.entity.KieuDang;
import com.example.demo.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MauSacRepository extends JpaRepository<MauSac, Integer> {

    @Query(value = "Select e from MauSac e where e.trangthai = 0")
    Page<MauSac> phantrang(Pageable pageable);

    @Query("Select e from MauSac e where e.trangthai = 0")
    List<MauSac> countPhanTrang();
}
