package com.ara.repository;

import com.ara.model.Product;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, Long> {
    Product findByProductcode(String productcode);
}