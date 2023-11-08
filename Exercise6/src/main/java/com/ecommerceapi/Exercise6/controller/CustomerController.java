package com.ecommerceapi.Exercise6.controller;

import com.ecommerceapi.Exercise6.entity.Customer;
import com.ecommerceapi.Exercise6.entity.JwtRequest;
import com.ecommerceapi.Exercise6.entity.JwtResponse;
import com.ecommerceapi.Exercise6.security.JwtHelper;
import com.ecommerceapi.Exercise6.service.CustomerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;


    private final Logger logger;

    @Autowired
    public CustomerController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    private UserDetailsService userDetailsService;



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
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
