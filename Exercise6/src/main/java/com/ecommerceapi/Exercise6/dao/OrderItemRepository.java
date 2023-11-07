package com.ecommerceapi.Exercise6.dao;

import com.ecommerceapi.Exercise6.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
}
