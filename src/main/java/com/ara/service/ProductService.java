package com.ara.service;

import com.ara.model.Product;

import java.util.List;

public interface ProductService {
    public abstract List<Product> findAll();
    public abstract Product findOne(Long id);
    public abstract void saveProduct(Product product);
    public abstract Product findByProductcode(String productcode);
}

