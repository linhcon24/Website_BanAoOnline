package com.example.demo.repository;

import com.example.demo.entity.KieuDang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KieuDangRepository extends JpaRepository<KieuDang, Integer> {

    @Query(value = "Select e from KieuDang e where e.trangthai = 0")
    Page<KieuDang> phantrang(Pageable pageable);
    @Query("Select e from KieuDang e where e.trangthai = 0")
    List<KieuDang> countPhanTrang();
}
