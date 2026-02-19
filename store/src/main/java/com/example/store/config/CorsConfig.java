package com.example.store.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
private static final String angular_URL ="http://localhost:4200";
private static final String[] allowed_Methods = {"GET",
        "POST",
        "PUT",
        "DELETE",
        "OPTIONS"};

  @Override
  public void addCorsMappings(CorsRegistry registry){
       registry.addMapping("/**")
               .allowedOrigins(angular_URL)
                     .allowedMethods(allowed_Methods);
            }
        }


