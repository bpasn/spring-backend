package com.ecommerce.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        final String RESOURCE_PATH = "classpath:/opt/stores/";
        /*
        * * 1.  `addResourceHandler("/static/**")` defines the URL pattern to access static resource. For example, if you have a file named `styles.css` in the
        *        `resource/static/css` directory, you can access it using the URL
        *        `/static/css/styles.css`.
        * 2. `addResourceLocations("classpath:/static/")` specifies the location of the static resources in the classpath.
        *       This means Spring Boot will look for static resource in the `resources/static` directory and its subdirectories.
        *
        * ! After configuring the `StaticResourceConfig` class, your Spring Boot application will
        *       automatically serve static resources from the specified directory tree when you access the corresponding URLs. Make sure
        *       to replace `/static/**` white the URL pattern that suits your application's needs
        */
        registry .addResourceHandler("/dir-tree/opt/storage/**").addResourceLocations(RESOURCE_PATH);

    }
}
