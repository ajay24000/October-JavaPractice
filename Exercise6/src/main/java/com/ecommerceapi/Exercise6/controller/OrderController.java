package com.ecommerceapi.Exercise6.controller;

import com.ecommerceapi.Exercise6.entity.OrderItem;
import com.ecommerceapi.Exercise6.entity.Orders;
import com.ecommerceapi.Exercise6.service.OrderService;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> list = orderService.getAllOrders();

        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable int id) {

        Orders order =  orderService.getOrderById(id);

        return new ResponseEntity<>(order,HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order)  {
        Orders orderCreated = orderService.createOrder(order);

        return new ResponseEntity<>(orderCreated,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable int id, @RequestBody Orders order) {
        Orders updatedOrder = orderService.updateOrder(id, order);

        return new ResponseEntity<>(updatedOrder,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    @PostMapping("/{orderId}/items")
    public void addOrderItem(@PathVariable int orderId, @RequestBody OrderItem orderItem) {
        orderService.addOrderItem(orderId, orderItem);
    }
}
