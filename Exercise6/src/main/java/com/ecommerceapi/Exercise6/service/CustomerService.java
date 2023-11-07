package com.ecommerceapi.Exercise6.service;

import com.ecommerceapi.Exercise6.dao.CustomerRepository;
import com.ecommerceapi.Exercise6.entity.Customer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Customer found with id: " + id));
    }

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);

    }

    public boolean existsByUsername(String username) {
        return customerRepository.existsByUsername(username);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(int id) {

        try {
            customerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

}
