package com.example.Ecommerce.API.service;


import com.example.Ecommerce.API.dao.OrdersRepository;
import com.example.Ecommerce.API.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrderServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Long orderId){
        return ordersRepository.findById(orderId);
    }

    @Override
    public Orders saveOrder(Orders order){
        return ordersRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        ordersRepository.deleteById(orderId);
    }
}
