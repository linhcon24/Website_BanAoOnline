package com.example.demo.repository;

import com.example.demo.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {

    @Query(value = "Select e from ChiTietSanPham e where e.trangthai = 0")
    Page<ChiTietSanPham> phantrang(Pageable pageable);
    @Query("Select e from ChiTietSanPham e where e.trangthai = 0")
    List<ChiTietSanPham> countPhanTrang();
}
