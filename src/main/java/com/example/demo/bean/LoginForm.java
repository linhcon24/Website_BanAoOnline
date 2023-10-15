package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginForm {


    @NotBlank(message = "{NotBlank.data.username}")
    private String username;

    @Length(min = 6, max = 12, message = "Length.data.password")
    @NotBlank(message = "{NotBlank.data.password}")
    private String password;
}
