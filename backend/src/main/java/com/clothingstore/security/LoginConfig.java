package com.clothingstore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class LoginConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/login")
                        .allowedOrigins("http://localhost:4200")
                        .allowedHeaders("access_token", "refresh_token")
                        .exposedHeaders("access_token", "refresh_token")
                        .allowCredentials(true);
            }
        };
    }
}
