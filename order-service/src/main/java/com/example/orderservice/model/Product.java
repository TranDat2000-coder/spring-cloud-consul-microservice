package com.example.orderservice.model;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private int price;
}
