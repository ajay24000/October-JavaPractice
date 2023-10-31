package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
}
