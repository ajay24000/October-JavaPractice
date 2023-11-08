package com.ecommerceapi.Exercise6.dao;

import com.ecommerceapi.Exercise6.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Integer> {
}
