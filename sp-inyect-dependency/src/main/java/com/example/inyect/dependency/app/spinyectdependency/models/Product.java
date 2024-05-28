package com.example.inyect.dependency.app.spinyectdependency.models;

public class Product {

    private Long id;
    private Long price;
    private String name;

    public Product(){

    }

    public Product(Long id, String name, Long price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
