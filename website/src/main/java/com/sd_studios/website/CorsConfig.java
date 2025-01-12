package com.sd_studios.website;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow OPTIONS for preflight
                .allowedHeaders("Content-Type", "Authorization") // Explicitly allow headers
                .allowCredentials(true);
    }
}
