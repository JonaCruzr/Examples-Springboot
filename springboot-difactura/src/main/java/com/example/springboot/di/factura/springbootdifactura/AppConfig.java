package com.example.springboot.di.factura.springbootdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.springboot.di.factura.springbootdifactura.models.Item;
import com.example.springboot.di.factura.springbootdifactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemInvoice(){
        Product p1 = new Product("Camara Sony", 5000);
        Product p2 = new Product("Bicicleta Urbana R26", 2500);

        return Arrays.asList(
            new Item(p1, 2), 
            new Item(p2, 1)
        );
    }
}
