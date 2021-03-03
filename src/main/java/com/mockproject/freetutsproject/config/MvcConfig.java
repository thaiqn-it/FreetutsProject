package com.mockproject.freetutsproject.config;

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
    @Value("${image-path}")
    private String imagePath;
   
    @Value("${content-file-path}")
    private String contentFilePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapping images storage on hard disk
        // For Windows
        registry.addResourceHandler("/images/**").addResourceLocations("file:///" + imagePath);

        // For Linux and MacOS
        //registry.addResourceHandler("/images/**").addResourceLocations("file:/" + imagePath);
        
        // Mapping content files storage on hard disk
        // For Windows
        registry.addResourceHandler("/contents/**").addResourceLocations("file:///" + contentFilePath);

        // For Linux and MacOS
        //registry.addResourceHandler("/images/**").addResourceLocations("file:/" + contentFilePath);

        // Mapping for static resource
        /*
           This is default of thymeleaf but since we custom resource
           handler to be able to read files from local disk we must do this explicitly
         */
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
