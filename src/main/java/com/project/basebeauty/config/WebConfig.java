package com.project.basebeauty.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Serve images from the "images" directory inside the classpath
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/images/");

        // Serve all other static resources from the "static" directory inside the classpath
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }
}
