package com.example.demo.repository;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.KichThuocViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {

    @Query(value = "Select e from KichThuoc e where e.trangthai = 0")
    Page<KichThuoc> phantrang(Pageable pageable);
    @Query("Select e from KichThuoc e where e.trangthai = 0")
    List<KichThuoc> countPhanTrang();

    @Query(value = "Select new com.example.demo.entity.KichThuocViewModel(e.idkichthuoc,e.tenkichthuoc) from KichThuoc e join ChiTietSanPham ctsp on ctsp.kichThuoc.idkichthuoc = e.idkichthuoc where ctsp.trangthai = 0 and ctsp.sanPham.idsanpham =:idsanpham group by e.idkichthuoc,e.tenkichthuoc")
    List<KichThuocViewModel> getListKichThuocByIdSanPham(@Param("idsanpham") Integer idSanPham);
}
