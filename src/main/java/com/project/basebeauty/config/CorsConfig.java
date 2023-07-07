package com.project.basebeauty.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration

public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Replace "/api/**" with the appropriate API endpoint
                .allowedOrigins("http://localhost:3000") // Replace with the frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Add the allowed HTTP methods
                .allowedHeaders("*") // Add the allowed headers
                .allowCredentials(true); // Set to true if you need to include cookies in the requests
    }
}
