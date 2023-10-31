package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.entity.Orders;

import java.util.List;
import java.util.Optional;
public interface OrderService {

    List<Orders> getAllOrders();
    Optional<Orders> getOrderById(Long orderId);
    Orders saveOrder(Orders order);
    void deleteOrder(Long orderId);
}
