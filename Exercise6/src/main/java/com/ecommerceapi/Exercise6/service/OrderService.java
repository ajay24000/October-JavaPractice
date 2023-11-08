package com.ecommerceapi.Exercise6.service;

import com.ecommerceapi.Exercise6.dao.OrderItemRepository;
import com.ecommerceapi.Exercise6.dao.OrderRepository;
import com.ecommerceapi.Exercise6.entity.OrderItem;
import com.ecommerceapi.Exercise6.entity.Orders;
import com.ecommerceapi.Exercise6.entity.Product;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderItemRepository orderItemRepository;


    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders createOrder(Orders order) {

        for (OrderItem item : order.getItems()) {

            // Assuming you have a ProductService to retrieve the product details by ID
            Product product = productService.getProductById(item.getProduct().getId());

            item.setProduct(product);
            item.setPricePerProduct(product.getPrice());  // Set the price per product based on the retrieved product
            item.setTotalPrice(item.getPricePerProduct() * item.getQuantity());
        }

        return orderRepository.save(order);
    }


    public Orders getOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Order found with id: " + id));
    }

    public Orders updateOrder(int id, Orders order) {
        Orders existingOrder = getOrderById(id);
        existingOrder.setCustomerName(order.getCustomerName());
        existingOrder.setItems(order.getItems());

       return orderRepository.save(existingOrder);

    }

    public void deleteOrder(int id) {
         orderRepository.deleteById(id);
    }

    public void addOrderItem(int orderId, OrderItem orderItem) {
        Orders order = getOrderById(orderId);

        // Fetch the product from the database based on the product ID
        Product product = productService.getProductById(orderItem.getProduct().getId());

        // Calculate the price per product and the total price
        double pricePerProduct = product.getPrice();
        double totalPrice = pricePerProduct * orderItem.getQuantity();

        // Set the calculated values in the order item
        orderItem.setOrders(order);
        orderItem.setProduct(product);
        orderItem.setPricePerProduct(pricePerProduct);
        orderItem.setTotalPrice(totalPrice);

        OrderItem savedOrderItem = orderItemRepository.save(orderItem);

        order.getItems().add(orderItem);
        orderRepository.save(order);

        // Print the added OrderItem with the associated Order ID
        System.out.println("Added OrderItem with Order ID " + orderId);
        System.out.println("OrderItem ID: " + orderItem.getId());
        System.out.println("Product: " + orderItem.getProduct().getName());
        System.out.println("Quantity: " + orderItem.getQuantity());
        System.out.println("Price: " + orderItem.getPricePerProduct());
        System.out.println();
    }
}
