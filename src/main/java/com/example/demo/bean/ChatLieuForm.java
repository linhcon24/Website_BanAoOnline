package com.example.demo.bean;

import com.example.demo.entity.ChatLieu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatLieuForm {

    private Integer idchatlieu;
    private String tenchatlieu;

    public ChatLieu data(ChatLieu chatLieu){
        if (chatLieu == null){
            chatLieu = new ChatLieu();
        }
        chatLieu.setIdchatlieu(this.getIdchatlieu());
        chatLieu.setTenchatlieu(this.getTenchatlieu());
        return chatLieu;
    }
}
