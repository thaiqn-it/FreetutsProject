package com.mockproject.freetutsproject.info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@PropertySource("classpath:fileStorage.properties")
public class MvcConfig implements WebMvcConfigurer {
    @Value("${content-file-path}")
    private String path;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapping contents storage on hard disk
        // For Windows
        registry.addResourceHandler("/contents/**").addResourceLocations("file:///" + path);

        // For Linux and MacOS
        //registry.addResourceHandler("/images/**").addResourceLocations("file:/" + path);

        // Mapping for static resource
        /*
           This is enable by default of thymeleaf but since we custom resource
            handler to be able to read image from local disk we must do this explicitly
         */
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
