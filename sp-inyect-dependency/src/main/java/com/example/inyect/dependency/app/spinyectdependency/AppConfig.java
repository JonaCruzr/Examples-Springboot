package com.example.inyect.dependency.app.spinyectdependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.inyect.dependency.app.spinyectdependency.repositories.ProductRepositoryJson;

@Configuration
public class AppConfig {
    
    /*
     * Se está creando un @Component propio
     */

    @Bean
    public ProductRepositoryJson productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}
