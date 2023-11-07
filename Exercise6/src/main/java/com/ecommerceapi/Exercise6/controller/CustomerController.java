package com.ecommerceapi.Exercise6.controller;

import com.ecommerceapi.Exercise6.entity.Customer;
import com.ecommerceapi.Exercise6.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> list = customerService.getAllCustomers();
        if(list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {

        Customer customer = customerService.getCustomerById(id);

        return new ResponseEntity<>(customer,HttpStatus.FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {

        if (customerService.existsByUsername(customer.getUsername())){
            return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
        }
        Customer registeredCustomer = customerService.registerCustomer(customer);

        return new ResponseEntity<>(registeredCustomer,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id , @RequestBody Customer customer) {

        Customer existingCustomer = customerService.getCustomerById(id);

        existingCustomer.setUsername(customer.getUsername());
        existingCustomer.setPassword(customer.getPassword());

        Customer updatedCustomer = customerService.updateCustomer(existingCustomer);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id ) {

        customerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Customer loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if ("admin".equals(username) && "password123".equals(password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }
}
