package com.example.inyect.dependency.app.spinyectdependency.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.example.inyect.dependency.app.spinyectdependency.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    public ProductRepositoryJson (){
        //Aquí se lee el archivo JSON
        ClassPathResource resource = new ClassPathResource("json/product.json");
        //Para convertir JSON en un objeto Java
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        for (Product product : list) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    
}
