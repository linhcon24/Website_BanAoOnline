package com.example.demo.bean;

import com.example.demo.entity.TaiKhoan;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class RegisterForm {

    private String image;

    @NotBlank(message = "{NotBlank.register.username}")
    private String username;
    @NotBlank(message = "{NotBlank.register.password}")
    @Length(min = 6, max = 12, message = "{Length.register.password}")
    private String password;
    @NotBlank(message = "{NotBlank.register.rePassword}")
    @Length(min = 6, max = 12, message = "{Length.register.rePassword}")
    private String rePassword;
    @NotBlank(message = "{NotBlank.register.email}")
    @Email(message = "{Format.register.email}")
    private String email;

    private Integer trangThai;


    public TaiKhoan data(TaiKhoan taiKhoan){
        if (taiKhoan == null){
            taiKhoan = new TaiKhoan();
        }
        taiKhoan.setUsername(this.getUsername());
        taiKhoan.setPassword(this.getPassword());
        taiKhoan.setEmail(this.getEmail());
        taiKhoan.setImage(this.getImage());


        return taiKhoan;
    }
}
