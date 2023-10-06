package com.example.demo.repository;

import com.example.demo.entity.DanhGiaSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DanhGiaSanPhamRepository extends JpaRepository<DanhGiaSanPham, UUID> {
    @Query(value = "Select e from DanhGiaSanPham e where e.trangthai = 0")
    Page<DanhGiaSanPham> phantrang(Pageable pageable);

    @Query("Select e from DanhGiaSanPham e where e.trangthai = 0")
    List<DanhGiaSanPham> countPhanTrang();
}
