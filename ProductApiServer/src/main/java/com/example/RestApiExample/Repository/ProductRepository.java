package com.example.RestApiExample.Repository;

import com.example.RestApiExample.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
