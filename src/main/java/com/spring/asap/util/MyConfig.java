package com.spring.asap.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8100", "https://asap.up.railway.app", "capacitor://localhost") // Explicit origins
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true) // Allow credentials
                .maxAge(3600); // Cache the preflight response for 1 hour
    }
}
