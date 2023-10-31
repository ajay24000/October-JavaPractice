package com.example.Ecommerce.API.dao;

import com.example.Ecommerce.API.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {


}
