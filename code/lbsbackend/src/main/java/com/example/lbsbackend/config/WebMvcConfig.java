package com.example.lbsbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.HttpHeaders.SET_COOKIE;

/**
 * @ClassName WebMvcConfig
 * @Description web mvc config
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .exposedHeaders(SET_COOKIE)
                .maxAge(1000);
    }
}
