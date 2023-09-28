package com.example.demo.repository;

import com.example.demo.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Integer> {

    @Query(value = "Select e from ThuongHieu e where e.trangthai = 0")
    Page<ThuongHieu> phantrang(Pageable pageable);
    @Query("Select e from ThuongHieu e where e.trangthai = 0")
    List<ThuongHieu> countPhanTrang();
}
