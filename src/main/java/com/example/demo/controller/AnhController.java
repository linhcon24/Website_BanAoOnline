package com.example.demo.controller;

import com.example.demo.bean.AnhForm;
import com.example.demo.entity.Anh;
import com.example.demo.service.AnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/anhs")
public class AnhController {

    @Autowired
    private AnhService service;

    @GetMapping()
    public String showAnh(Model model, @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        Integer pageSize = 5;
        List<Anh> list = service.getAll(pageNum - 1, pageSize).getContent();
        List<Anh> count = service.count();
        model.addAttribute("listAnh", list);
        Integer count1 = Math.round(count.size() % pageSize) == 0 ? Math.round(count.size() / pageSize)
                : Math.round(count.size() / pageSize) + 1;
        model.addAttribute("count", count1);
        list.toString();
        return "adminAnh";
    }

    @GetMapping("/add")
    public String getAddAnh(Model model) {
        model.addAttribute("anh", new Anh());
        return "adminAnhAdd";
    }

    @PostMapping("/add")
    public String addAnh(Model model, RedirectAttributes redirect, @ModelAttribute(name = "anh") AnhForm form,
                         BindingResult result, @RequestParam("imageFile") MultipartFile[] imageFiles, HttpServletRequest request) {
        if (!result.hasErrors()) {
            Anh anh = form.data(null);
            anh.setTrangthai(0);

            List<String> fileUrls = new ArrayList<>();
            String appPath = request.getServletContext().getRealPath("");
            String uploadDir = appPath + File.separator + "views" + File.separator + "uploads/";
            uploadDir = uploadDir.replace("\\\\", "\\");
            System.out.println(uploadDir);
            for (MultipartFile imageFile : imageFiles) {
//                if (!isImageFormatValid(imageFile)) {
//                    // Định dạng không hợp lệ, xử lý lỗi tại đây
//                    redirect.addFlashAttribute("message", "Định dạng tệp ảnh không hợp lệ.");
//                    redirect.addFlashAttribute("type", "error");
//                    return "redirect:/admin/anhs/add";
//                }
                // Lưu file vào thư mục trong webapp/views/admin/img
                String fileName = imageFile.getOriginalFilename();
                try {
                    byte[] bytes = imageFile.getBytes();
                    Path path = Paths.get(uploadDir + fileName);
                    Files.write(path, bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Lưu URL của file vào danh sách
                fileUrls.add(fileName);
            }
            // Lưu các URL vào đối tượng Anh
            anh.setImageurl1(fileUrls.get(0));
            anh.setImageurl2(fileUrls.get(1));
            anh.setImageurl3(fileUrls.get(2));
            anh.setImageurl4(fileUrls.get(3));

            if (service.add(anh) != null) {
                redirect.addFlashAttribute("message", "Thêm thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/anhs";
            }
        }
        return "adminAnhAdd";
    }

    @GetMapping("/update/{id}")
    public String getUpdateAnh(Model model, @PathVariable(name = "id") UUID id) {
        Anh a = service.getByIdA(id);
        model.addAttribute("anh1", a);
        model.addAttribute("anh", new AnhForm());
        return "adminAnhUpdate";
    }

    @PostMapping("/update")
    public String updateAnh(Model model, RedirectAttributes redirect, @ModelAttribute(name = "anh") AnhForm form,
                            BindingResult result, @RequestParam("imageFile") MultipartFile[] imageFiles, HttpServletRequest request) {
        if (!result.hasErrors()) {
            Anh anh = service.getByIdA(form.getIdimage());
            Anh a = form.data(anh);

            List<String> fileUrls = new ArrayList<>();
            String appPath = request.getServletContext().getRealPath("");
            String uploadDir = appPath + File.separator + "views" + File.separator + "uploads/";
            uploadDir = uploadDir.replace("\\\\", "\\");
            System.out.println(uploadDir);
            for (MultipartFile imageFile : imageFiles) {
//                if (!isImageFormatValid(imageFile)) {
//                    // Định dạng không hợp lệ, xử lý lỗi tại đây
//                    redirect.addFlashAttribute("message", "Định dạng tệp ảnh không hợp lệ.");
//                    redirect.addFlashAttribute("type", "error");
//                    return "redirect:/admin/anhs/update";
//                }
                // Lưu file vào thư mục trong webapp/views/admin/img
                String fileName = imageFile.getOriginalFilename();
                try {
                    byte[] bytes = imageFile.getBytes();
                    Path path = Paths.get(uploadDir + fileName);
                    Files.write(path, bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Lưu URL của file vào danh sách
                fileUrls.add(fileName);
            }
            // Lưu các URL vào đối tượng Anh
            anh.setImageurl1(fileUrls.get(0));
            anh.setImageurl2(fileUrls.get(1));
            anh.setImageurl3(fileUrls.get(2));
            anh.setImageurl4(fileUrls.get(3));

            if (service.add(a) != null) {
                redirect.addFlashAttribute("message", "Sửa thành công !");
                redirect.addFlashAttribute("type", "success");
                return "redirect:/admin/anhs";
            }
        }
        return "adminAnhUpdate";
    }

    @GetMapping("/delete/{id}")
    public String xoaAnh(Model model, @PathVariable(name = "id") UUID id, RedirectAttributes redirect) {
        Anh anh = service.getByIdA(id);
        if (service.delete(anh) != null) {
            redirect.addFlashAttribute("message", "Xóa thành công !");
            redirect.addFlashAttribute("type", "success");
            return "redirect:/admin/anhs";
        }
        return "adminAnh";
    }

    private boolean isImageFormatValid(MultipartFile file) {
        String[] allowedExtensions = {"png", "jpg", "jpeg", "gif", "svg"};
        String originalFileName = file.getOriginalFilename();
        if (originalFileName != null) {
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            for (String extension : allowedExtensions) {
                if (extension.equalsIgnoreCase(fileExtension)) {
                    return true;
                }
            }
        }
        return false;
    }
}
