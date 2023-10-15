package com.example.demo.configuration;

import com.example.demo.filter.AdminIntercreptor;
import com.example.demo.filter.LoginIntercreptor;
import com.example.demo.filter.UserIntercreptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private AdminIntercreptor adminIntercreptor;

    @Autowired
    private LoginIntercreptor loginIntercreptor;

    @Autowired
    private UserIntercreptor userIntercreptor;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.addBasenames("classpath:message/validation");
        source.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return source;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercreptor).addPathPatterns("/admin/**", "/cart/**","/profile/**")
                .excludePathPatterns("/product","/contact" ,"/info", "/detail", "/index", "/register","/forget");
        registry.addInterceptor(userIntercreptor).addPathPatterns("/admin/**")
                .excludePathPatterns("/product", "/info", "/detail", "/register", "/cart/**", "/index" ,"/contact","/forget","/profile/**");
        registry.addInterceptor(adminIntercreptor).addPathPatterns("/login");
    }
}
