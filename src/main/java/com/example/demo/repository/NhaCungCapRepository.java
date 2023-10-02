package com.example.demo.repository;

import com.example.demo.entity.NhaCungCap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer> {

    @Query(value = "Select e from NhaCungCap e where e.trangthai = 0")
    Page<NhaCungCap> phantrang(Pageable pageable);
    @Query("Select e from NhaCungCap e where e.trangthai = 0")
    List<NhaCungCap> countPhanTrang();
}
