package com.ecommerceapi.Exercise6.controller;

import com.ecommerceapi.Exercise6.entity.Product;
import com.ecommerceapi.Exercise6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> list = productService.getAllProducts();
        if(list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {

        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {

        if (product.getPrice() <= 0) {
            return new ResponseEntity<>("Product price must be a positive value", HttpStatus.BAD_REQUEST);
        }

        Product createdProduct = productService.addProduct(product);
        return new ResponseEntity<>(createdProduct,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id , @RequestBody Product updatedProduct) {

        Product existingProduct = productService.getProductById(id);

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());

        Product savedProduct = productService.updateProduct(existingProduct);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {

        productService.deleteProductById(id);
        return new ResponseEntity<>("Product of Id provided deleted successfully",HttpStatus.NO_CONTENT);
    }

}
