package com.example.demo.service.impl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ISanPhamService implements SanPhamService {

    @Autowired
    private SanPhamRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<SanPham> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<SanPham> getAll2() {
        return repository.findAll();
    }

    @Override
    public List<SanPham> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<SanPham> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public SanPham add(SanPham sanPham) {
        return repository.save(sanPham);
    }

    @Override
    public SanPham update(SanPham sanPham) {
        SanPham sp = repository.getById(sanPham.getIdsanpham());
        sp.setTensanpham(sanPham.getTensanpham());
        return repository.save(sp);
    }

    @Override
    public SanPham delete(SanPham sanPham) {
        SanPham sp = repository.getById(sanPham.getIdsanpham());
        sp.setTrangthai(1);
        return repository.save(sp);
    }

    @Override
    public SanPham getByIdSP(Integer id) {
        return repository.getById(id);
    }

    @Transactional
    public String generateNextProductCode() {
        // Truy vấn cơ sở dữ liệu để lấy mã sản phẩm cuối cùng
        Query query = entityManager.createQuery("SELECT p.masanpham FROM SanPham p ORDER BY p.masanpham DESC");
        query.setMaxResults(1);
        List<String> results = query.getResultList();
        String lastProductCode = results.isEmpty() ? null : results.get(0);
        // Tạo mã sản phẩm tiếp theo
        String nextProductCode;
        if (lastProductCode != null) {
            int lastCode = Integer.parseInt(lastProductCode.substring(2)); // Loại bỏ "SP" và chuyển thành số
            int nextCode = lastCode + 1;
            nextProductCode = "SP" + String.format("%04d", nextCode); // Định dạng lại thành "SPxxxx"
        } else {
            // Nếu không có mã sản phẩm nào trong cơ sở dữ liệu, tạo mã sản phẩm đầu tiên
            nextProductCode = "SP0001";
        }
        return nextProductCode;
    }
}
