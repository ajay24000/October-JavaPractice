package com.example.Ecommerce.API.entity;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long productId;
    private String name;
    private double price;

    public Product() {
    }

    public Product(Long productId, String name, double price) {
        super();
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return productId;
    }

    public void setId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
