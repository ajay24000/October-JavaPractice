package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {

    List<OrderItem> getAllOrderItems();

    Optional<OrderItem> getOrderItemById(Long orderItemId);

    OrderItem saveOrderItem(OrderItem orderItem);

    void deleteOrderItem(Long orderItemId);

}
