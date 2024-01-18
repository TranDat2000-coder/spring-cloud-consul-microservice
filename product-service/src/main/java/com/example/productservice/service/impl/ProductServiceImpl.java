package com.example.productservice.service.impl;

import com.example.productservice.entity.ProductEntity;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> getAllProduct() {
        List<ProductEntity> products = productRepository.findAll();

        return products;
    }
}
