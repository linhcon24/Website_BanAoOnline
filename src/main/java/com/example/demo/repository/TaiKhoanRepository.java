package com.example.demo.repository;

import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan , Integer> {

    @Query(value = "Select e from TaiKhoan e where e.trangthai = 0")
    Page<TaiKhoan> phantrang(Pageable pageable);
    @Query("Select e from TaiKhoan e where e.trangthai = 0")
    List<TaiKhoan> countPhanTrang();
    @Query(value = "Select e from TaiKhoan e where e.username like :username")
    TaiKhoan getByUsername(@Param("username") String username);

}
