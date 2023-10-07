package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/product")
public class DetailOrAddToCartController {

    @Autowired
    HttpSession session;


    @PostMapping("/add-to-cart")
    public String AddToCart(RedirectAttributes redirect){
        session.getAttribute("account");
        redirect.addFlashAttribute("message", "Sản phẩm đã được thêm vào giỏ hàng");
        redirect.addFlashAttribute("type", "success");
        return "redirect:/product";
    }
}
