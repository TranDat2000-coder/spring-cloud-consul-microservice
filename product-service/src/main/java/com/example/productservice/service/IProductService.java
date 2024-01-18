package com.example.productservice.service;

import com.example.productservice.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductEntity> getAllProduct();
}
