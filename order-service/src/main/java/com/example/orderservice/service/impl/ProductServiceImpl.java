package com.example.orderservice.service.impl;

import com.example.orderservice.feignclient.ProductClient;
import com.example.orderservice.model.Product;
import com.example.orderservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductClient productClient;

    @Override
    public List<Product> getAllProduct() {
        return productClient.findByIds();
    }
}
