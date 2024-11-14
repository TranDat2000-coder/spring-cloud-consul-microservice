package com.example.orderservice.controller;

import com.example.orderservice.model.Product;
import com.example.orderservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/lst-product")
    public List<Product> findProduct(){
        return productService.getAllProduct();
    }
}
