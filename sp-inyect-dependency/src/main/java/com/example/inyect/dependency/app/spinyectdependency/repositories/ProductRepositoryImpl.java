package com.example.inyect.dependency.app.spinyectdependency.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.inyect.dependency.app.spinyectdependency.models.Product;

/*
 * el Repositorio se centra en el acceso y manipulación de datos 
 * Es la capa de acceso a datos
 */

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> products;

    public ProductRepositoryImpl(){
        this.products = Arrays.asList(
           new Product(1L, "Jabon", 25L),
           new Product(2L, "Shampoo", 47L),
           new Product(3L, "Pasta dental", 55L),
           new Product(4L, "Aceite", 60L)
        );
    }

    @Override
    public List<Product> findAll(){
        return products;
    }

    @Override
    public Product findById(Long id){
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
