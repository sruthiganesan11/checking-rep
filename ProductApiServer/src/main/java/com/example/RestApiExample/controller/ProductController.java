package com.example.RestApiExample.controller;

import com.example.RestApiExample.Repository.ProductRepository;
import com.example.RestApiExample.domain.Product;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Iterable<Product> getProducts() {
        return this.productRepository.findAll();
    }


    @PostMapping(value = "",consumes = "application/json")
    Product postProduct(@RequestBody Product products) {
        Product savedProduct = this.productRepository.save(products);
        return savedProduct;
    }
}
