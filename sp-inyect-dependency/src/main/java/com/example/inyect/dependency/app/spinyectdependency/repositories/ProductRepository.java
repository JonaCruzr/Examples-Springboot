package com.example.inyect.dependency.app.spinyectdependency.repositories;

import java.util.List;

import com.example.inyect.dependency.app.spinyectdependency.models.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
