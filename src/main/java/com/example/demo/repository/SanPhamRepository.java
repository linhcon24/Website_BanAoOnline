package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    @Query(value = "Select e from SanPham e where e.trangthai= 0")
    Page<SanPham> phantrang(Pageable pageable);
    @Query("Select e from SanPham e where e.trangthai = 0")
    List<SanPham> countPhanTrang();
}
