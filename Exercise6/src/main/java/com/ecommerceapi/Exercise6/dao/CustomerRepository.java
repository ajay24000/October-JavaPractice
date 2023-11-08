package com.ecommerceapi.Exercise6.dao;

import com.ecommerceapi.Exercise6.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByUsername(String username);
    public Optional<Customer> findByUsername(String username);

}
