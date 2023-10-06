package com.example.demo.repository;

import com.example.demo.entity.BaiDang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BaiDangRepository extends JpaRepository<BaiDang, UUID> {
    @Query(value = "Select e from BaiDang e where e.trangthai = 0")
    Page<BaiDang> phantrang(Pageable pageable);

    @Query("Select e from BaiDang e where e.trangthai = 0")
    List<BaiDang> countPhanTrang();
}
