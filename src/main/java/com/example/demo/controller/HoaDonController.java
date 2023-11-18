package com.example.demo.controller;

@Controller
@RequestMapping("/view-hoa-don")
public class HoaDonController {
    @Autowired
    private IHoaDonChiTietRepository iHoaDonChiTietRepository;

    @GetMapping("/hoa-don")
    public String viewHoaDon(Model model, @RequestParam(defaultValue = "1") int page) {
        Page<HoaDonChiTiet> hoaDonChiTietPage;
        if (page < 1) {
            page = 1;
        }
        Sort sort = Sort.by("ngayTao").descending();
        Pageable pageable = PageRequest.of(page - 1, 20, sort);
        hoaDonChiTietPage = iHoaDonChiTietRepository.findAll(pageable);
        model.addAttribute("hoaDonChiTietPage", hoaDonChiTietPage);
        return "view-hoa-don/view-hoa-don";
    }
}