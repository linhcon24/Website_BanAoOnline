package com.example.demo.repository;

import com.example.demo.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Integer> {
    @Query(value = "Select e from KhuyenMai e where e.trangthai = 0")
    Page<KhuyenMai> phantrang(Pageable pageable);

    @Query("Select e from KhuyenMai e where e.trangthai = 0")
    List<KhuyenMai> countPhanTrang();
}
