package com.ecommerceapi.Exercise6.dao;

import com.ecommerceapi.Exercise6.entity.Orders;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
