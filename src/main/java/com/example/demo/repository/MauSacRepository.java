package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.MauSacViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MauSacRepository extends JpaRepository<MauSac, Integer> {

    @Query(value = "Select e from MauSac e where e.trangthai = 0")
    Page<MauSac> phantrang(Pageable pageable);

    @Query("Select e from MauSac e where e.trangthai = 0")
    List<MauSac> countPhanTrang();

    @Query(value = "Select new com.example.demo.entity.MauSacViewModel(e.idmausac,e.tenmausac) from MauSac e join ChiTietSanPham ctsp on ctsp.mauSac.idmausac = e.idmausac where ctsp.trangthai = 0 and ctsp.sanPham.idsanpham =:idsanpham group by e.idmausac,e.tenmausac")
    List<MauSacViewModel> getListMauSacByIdSanPham(@Param("idsanpham") Integer idSanPham);
}
