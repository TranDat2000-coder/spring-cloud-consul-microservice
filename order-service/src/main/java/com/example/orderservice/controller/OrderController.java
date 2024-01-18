package com.example.orderservice.controller;

import com.example.orderservice.feignclient.ProductClient;
import com.example.orderservice.model.Product;
import com.example.orderservice.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductClient productClient;

    @GetMapping(value = "/lst-product")
    public List<Product> findProduct(){
        return productClient.findByIds();
    }
}
