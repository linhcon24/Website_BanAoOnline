package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ChatLieuService {

    public Page<ChatLieu> getAll(Integer pageNum , Integer pageSize);
    public List<ChatLieu> count();
    public Optional<ChatLieu> getById(Integer id);
    public ChatLieu add(ChatLieu chatLieu);
    public ChatLieu update(ChatLieu chatLieu);
    public ChatLieu delete(ChatLieu chatLieu);
    public ChatLieu getByIdCL(Integer id);
}
