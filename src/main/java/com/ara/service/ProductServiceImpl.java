package com.ara.service;

import com.ara.model.Product;
import com.ara.repository.ProductJpaRepository;
import com.ara.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> findAll() {
        return productJpaRepository.findAll();
    }

    @Transactional
    public Product findOne(Long id) {
        return productJpaRepository.findOne(id);
    }

    @Transactional
    public void saveProduct(Product product) {
        productJpaRepository.save(product);
    }

    @Transactional
    public Product findByProductcode(String productcode){
        return productRepository.findByProductcode(productcode);
    }
}
