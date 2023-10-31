package com.example.Ecommerce.API.controller;

import com.example.Ecommerce.API.entity.Product;
import com.example.Ecommerce.API.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {

        List<Product> list = productService.getAllProducts();
        if(list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addProducts(@RequestBody Product product) {

        if (product.getPrice() <= 0) {
            return new ResponseEntity<>("Product price must be a positive value", HttpStatus.BAD_REQUEST);
        }
        Product createdProduct =  productService.saveProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long id, @RequestBody Product updatedProduct) {

        Product existingProduct = productService.getProductById(id);

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());

        Product savedProduct = productService.saveProduct(existingProduct);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);

    }


}
