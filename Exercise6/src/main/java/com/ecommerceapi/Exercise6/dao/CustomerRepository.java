package com.ecommerceapi.Exercise6.dao;

import com.ecommerceapi.Exercise6.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByUsername(String username);

}
