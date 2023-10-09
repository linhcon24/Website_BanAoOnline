package com.example.demo.configuration;

import com.example.demo.filter.AdminIntercreptor;
import com.example.demo.filter.LoginIntercreptor;
import com.example.demo.filter.UserIntercreptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private AdminIntercreptor adminIntercreptor;

    @Autowired
    private LoginIntercreptor loginIntercreptor;

    @Autowired
    private UserIntercreptor userIntercreptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercreptor).addPathPatterns("/admin/**", "/cart/**")
                .excludePathPatterns("/product","/contact" ,"/info", "/detail", "/index", "/register","/forget");
        registry.addInterceptor(userIntercreptor).addPathPatterns("/admin/**")
                .excludePathPatterns("/product", "/info", "/detail", "/register", "/cart/**", "/index" ,"/contact","/forget");
        registry.addInterceptor(adminIntercreptor).addPathPatterns("/login");
    }
}
