package com.example.demo.controller;

import com.example.demo.bean.ChiTietSanPhamForm;
import com.example.demo.bean.SanPhamForm;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/chi-tiet-sp")
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSanPhamService service;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private ThuongHieuService thuongHieuService;
    @Autowired
    private NhaCungCapService nhaCungCapService;
    @Autowired
    private KieuDangService kieuDangService;
    @Autowired
    private KichThuocService kichThuocService;
    @Autowired
    private ChatLieuService chatLieuService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private KhuyenMaiService khuyenMaiService;
    @Autowired
    private AnhService anhService;

    @GetMapping()
    public String showCTSP(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        Integer pageSize = 5;
        List<ChiTietSanPham> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<ChiTietSanPham> count = service.count();
        model.addAttribute("listCTSP", list);
        System.out.println(list.toString());
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminCTSP";
    }

    @GetMapping("/add")
    public String getAddCTSP(Model model){
        model.addAttribute("ctspForm", new ChiTietSanPhamForm());
        // Bổ sung code để lấy danh sách các bảng phụ và đưa vào model
        List<SanPham> sanPhamList = sanPhamService.getAll2();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll2();
        List<NhaCungCap> nhaCungCapList = nhaCungCapService.getAll2();
        List<KieuDang> kieuDangList = kieuDangService.getAll2();
        List<KichThuoc> kichThuocList = kichThuocService.getAll2();
        List<ChatLieu> chatLieuList = chatLieuService.getAll2();
        List<MauSac> mauSacList = mauSacService.getAll2();
        List<KhuyenMai> khuyenMaiList = khuyenMaiService.getAll2();
        List<Anh> anhList = anhService.getAll2();

        model.addAttribute("sanPhamList", sanPhamList);
        model.addAttribute("thuongHieuList", thuongHieuList);
        model.addAttribute("nhaCungCapList", nhaCungCapList);
        model.addAttribute("kieuDangList", kieuDangList);
        model.addAttribute("kichThuocList", kichThuocList);
        model.addAttribute("chatLieuList", chatLieuList);
        model.addAttribute("mauSacList", mauSacList);
        model.addAttribute("khuyenMaiList", khuyenMaiList);
        model.addAttribute("anhList", anhList);
        return "adminCTSPAdd";
    }
    @PostMapping("/add")
    public String addCTSP(Model model, RedirectAttributes redirect,
                          @ModelAttribute(name = "ctspForm") ChiTietSanPhamForm form,
                          BindingResult result) {
        if (!result.hasErrors()) {
            ChiTietSanPham chiTietSanPham = form.data(null);
            chiTietSanPham.setTrangthai(0);
            if (service.add(chiTietSanPham) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/chi-tiet-sp";
            }
        }
        // Nếu có lỗi, cần trả về trang thêm lại và đảm bảo danh sách các bảng phụ vẫn được thêm vào model để hiển thị trong form
        model.addAttribute("sanPhamList", sanPhamService.getAll2());
        model.addAttribute("thuongHieuList", thuongHieuService.getAll2());
        model.addAttribute("nhaCungCapList", nhaCungCapService.getAll2());
        model.addAttribute("kieuDangList", kieuDangService.getAll2());
        model.addAttribute("kichThuocList", kichThuocService.getAll2());
        model.addAttribute("chatLieuList", chatLieuService.getAll2());
        model.addAttribute("mauSacList", mauSacService.getAll2());
        model.addAttribute("khuyenMaiList", khuyenMaiService.getAll2());
        model.addAttribute("anhList", anhService.getAll2());
        return "adminCTSPAdd";
    }

    @GetMapping("/update/{id}")
    public String getUpdateCTSP(Model model, @PathVariable(name = "id") Integer id) {
        ChiTietSanPham chiTietSanPham = service.getByIdCTSP(id);
        model.addAttribute("ctsp1", chiTietSanPham);
        model.addAttribute("listSP", sanPhamService.count());
        model.addAttribute("listTH", thuongHieuService.count());
        model.addAttribute("listNCC", nhaCungCapService.count());
        model.addAttribute("listKD", kieuDangService.count());
        model.addAttribute("listKT", kichThuocService.count());
        model.addAttribute("listCL", chatLieuService.count());
        model.addAttribute("listMS", mauSacService.count());
        model.addAttribute("listKM", khuyenMaiService.count());
        model.addAttribute("listAnh", anhService.count());
        model.addAttribute("ctsp", new ChiTietSanPhamForm());
        return "adminCTSPUpdate";
    }
    @PostMapping("/update")
    public String updateCTSP(Model model, RedirectAttributes redirect, @ModelAttribute(name = "data") ChiTietSanPhamForm form,
                           BindingResult result) {
        if (!result.hasErrors()) {
            ChiTietSanPham chiTietSanPham = service.getByIdCTSP(form.getIdctsp());
            ChiTietSanPham ctsp = form.data(chiTietSanPham);

            if (service.update(ctsp) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/chi-tiet-sp";
            }
        }
        return "adminCTSPUpdate";
    }
    @GetMapping("/delete/{id}")
    public String xoaCTSP(Model model, @PathVariable(name = "id") Integer id, RedirectAttributes redirect) {
        ChiTietSanPham chiTietSanPham = service.getByIdCTSP(id);
        if (service.delete(chiTietSanPham) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/chi-tiet-sp";
        }
        return "adminCTSP";
    }
}
