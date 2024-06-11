package com.jona.crud.springboot.crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jona.crud.springboot.crud.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
