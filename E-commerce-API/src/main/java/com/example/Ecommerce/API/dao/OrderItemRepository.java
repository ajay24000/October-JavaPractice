package com.example.Ecommerce.API.dao;

import com.example.Ecommerce.API.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem , Long> {
}
