package com.example.Ecommerce.API.dao;

import com.example.Ecommerce.API.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
