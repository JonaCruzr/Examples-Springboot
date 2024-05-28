package com.example.inyect.dependency.app.spinyectdependency.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.inyect.dependency.app.spinyectdependency.models.Product;
import com.example.inyect.dependency.app.spinyectdependency.services.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")

public class ProductController {

    //Spring buscara un componente que implemente dicha interfaz y la inyectara
    @Autowired
    private ProductService productService; //Inyectando una interfaz

    @GetMapping
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product showProduct(@PathVariable Long id) {
        return productService.findById(id);
    }
    
    
}
