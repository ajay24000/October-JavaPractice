package com.example.Ecommerce.API.dao;

import com.example.Ecommerce.API.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer , Long> {

    Optional<Customer> findByUsername(String username);

    boolean existsByUsername(String username);
}
