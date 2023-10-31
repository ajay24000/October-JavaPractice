package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.dao.OrderItemRepository;
import com.example.Ecommerce.API.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public List<OrderItem> getAllOrderItems(){
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> getOrderItemById(Long orderItemId){
        return orderItemRepository.findById(orderItemId);
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }



}
