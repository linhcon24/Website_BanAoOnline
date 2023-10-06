package com.example.demo.repository;

import com.example.demo.entity.DanhSachYeuThich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DanhSachYeuThichRepository extends JpaRepository<DanhSachYeuThich, UUID> {
    @Query(value = "Select e from DanhSachYeuThich e where e.trangthai = 0")
    Page<DanhSachYeuThich> phantrang(Pageable pageable);

    @Query("Select e from DanhSachYeuThich e where e.trangthai = 0")
    List<DanhSachYeuThich> countPhanTrang();
}
