package com.example.demo.repository;

import com.example.demo.entity.GioHangChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {

    @Query(value = "Select e from GioHangChiTiet e where e.gioHang.taiKhoan.idtaikhoan =:idtaikhoan")
    Page<GioHangChiTiet> phantrang(Pageable pageable, @Param("idtaikhoan") Integer idTaiKhoan);
    @Query("Select e from GioHangChiTiet e where e.gioHang.taiKhoan.idtaikhoan =:idtaikhoan")
    List<GioHangChiTiet> countPhanTrang(@Param("idtaikhoan") Integer idTaiKhoan);
}
