package com.example.Ecommerce.API.service;

import com.example.Ecommerce.API.dao.CustomerRepository;
import com.example.Ecommerce.API.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer registerCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public Customer login(String username, String password) {
        return customerRepository.findByUsername(username)
                .filter(customer -> password.equals(customer.getPassword()))
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));
    }

    @Override
    public Customer updateProfile(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean existsByUsername(String username) {
        return customerRepository.existsByUsername(username);
    }

    @Override
    public Optional<Customer> findById(Long Id){
        return customerRepository.findById(Id);
    }
}
