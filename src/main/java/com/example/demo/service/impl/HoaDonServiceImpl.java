package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.TaiKhoan;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.repository.IHoaDonChiTietRepository;
import com.example.demo.repository.IHoaDonRepository;
import com.example.demo.repository.TaiKhoanRepository;
import com.example.demo.service.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HoaDonServiceImpl implements IHoaDonService {

    @Autowired
    private IGioHangService iGioHangService;
    @Autowired
    private TaiKhoanRepository iTaiKhoanRepository;
    @Autowired
    private ChiTietSanPhamRepository iChiTietSanPhamRepository;
    @Autowired
    private IHoaDonRepository iHoaDonRepository;
    @Autowired
    private IHoaDonChiTietRepository iHoaDonChiTietRepository;

    @Override
    public Boolean saveHoaDon(HoaDon hoaDonForm, String idGioHangChiTiet) {
        GioHangChiTiet gioHangChiTiet = iGioHangService.findOneGioHangChiTiet(idGioHangChiTiet);
        TaiKhoan taiKhoan = iTaiKhoanRepository.findById(gioHangChiTiet.getGioHang().getTaiKhoan().getIdtaikhoan()).get();
        ChiTietSanPham chiTietSanPham = iChiTietSanPhamRepository.findById(gioHangChiTiet.getChiTietSanPham().getIdctsp()).get();
        Date date = new Date();
        HoaDon hoaDon = new HoaDon(null, taiKhoan, GenMa.generateRandomLineOfCode(), date, date, date, date, hoaDonForm.getTenNguoiNhan(), hoaDonForm.getDiaChi(), hoaDonForm.getSoDienThoai(), 1);
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(null, chiTietSanPham, hoaDon, date, gioHangChiTiet.getSoLuong(), gioHangChiTiet.getDonGia());
        Integer soLuongBanDau = chiTietSanPham.getSoLuong();
        chiTietSanPham.setSoluong(soLuongBanDau - gioHangChiTiet.getSoLuong());
        iChiTietSanPhamRepository.save(chiTietSanPham);
        iHoaDonRepository.save(hoaDon);
        iHoaDonChiTietRepository.save(hoaDonChiTiet);
        iGioHangService.removeSanPhamTrongGio(gioHangChiTiet.getId());
        return true;
    }
}