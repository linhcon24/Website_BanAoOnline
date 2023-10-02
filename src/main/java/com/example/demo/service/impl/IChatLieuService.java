package com.example.demo.service.impl;

import com.example.demo.entity.ChatLieu;
import com.example.demo.repository.ChatLieuRepository;
import com.example.demo.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IChatLieuService implements ChatLieuService {

    @Autowired
    private ChatLieuRepository repository;

    @Override
    public Page<ChatLieu> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.phantrang(pageable);
    }

    @Override
    public List<ChatLieu> count() {
        return repository.countPhanTrang();
    }

    @Override
    public Optional<ChatLieu> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public ChatLieu add(ChatLieu chatLieu) {
        return repository.save(chatLieu);
    }

    @Override
    public ChatLieu update(ChatLieu chatLieu) {
        ChatLieu cl = repository.getById(chatLieu.getIdChatLieu());
        cl.setTenChatLieu(chatLieu.getTenChatLieu());
        return repository.save(cl);
    }

    @Override
    public ChatLieu delete(ChatLieu chatLieu) {
        ChatLieu cl = repository.getById(chatLieu.getIdChatLieu());
        cl.setTrangThai(1);
        return repository.save(cl);
    }

    @Override
    public ChatLieu getByIdCL(Integer id) {
        return repository.getById(id);
    }
}
