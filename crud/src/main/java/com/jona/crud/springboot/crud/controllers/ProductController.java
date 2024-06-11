package com.jona.crud.springboot.crud.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jona.crud.springboot.crud.entities.Product;
import com.jona.crud.springboot.crud.services.ProductServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
//Ruta base
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServicesImpl productServices;
    
    @GetMapping
    public List<Product> findAll(){
        return productServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional <Product> productoptional = productServices.findById(id);
        if(productoptional.isPresent()){
            return ResponseEntity.ok(productoptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productServices.save(product));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Optional <Product> productoptional = productServices.update(id, product);
        if(productoptional.isPresent())
            return ResponseEntity.status(HttpStatus.CREATED).body(productoptional.orElseThrow());
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional <Product> productoptional = productServices.delete(id);
        if(productoptional.isPresent()){
            return ResponseEntity.ok(productoptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    
}
