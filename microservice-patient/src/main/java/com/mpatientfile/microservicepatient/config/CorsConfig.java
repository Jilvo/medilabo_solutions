package com.mpatientfile.microservicepatient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/patients/**")
                .allowedOrigins("http://localhost:5173", "http://localhost:8080", "http://localhost:9002")
                .allowedMethods("GET", "PUT", "DELETE")
                .allowedHeaders("*");
        registry.addMapping("/api/patients")
                .allowedOrigins("http://localhost:5173", "http://localhost:8080")
                .allowedMethods("GET", "POST")
                .allowedHeaders("*");
    }
}
