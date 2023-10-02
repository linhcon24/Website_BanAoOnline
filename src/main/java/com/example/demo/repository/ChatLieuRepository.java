package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, Integer> {

    @Query(value = "Select e from ChatLieu e where e.trangThai = 0")
    Page<ChatLieu> phantrang(Pageable pageable);
    @Query("Select e from ChatLieu e where e.trangThai = 0")
    List<ChatLieu> countPhanTrang();
}
