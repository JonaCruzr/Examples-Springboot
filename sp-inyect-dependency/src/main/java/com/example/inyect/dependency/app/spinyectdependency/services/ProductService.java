package com.example.inyect.dependency.app.spinyectdependency.services;

import java.util.List;

import com.example.inyect.dependency.app.spinyectdependency.models.Product;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
