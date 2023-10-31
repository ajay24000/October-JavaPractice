package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer registerCustomer(Customer customer);
    Customer login(String username, String password);
    Customer updateProfile(Customer customer);

    boolean existsByUsername(String username);

    Optional<Customer> findById(Long Id);
}
