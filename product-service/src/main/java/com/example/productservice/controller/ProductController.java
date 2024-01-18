package com.example.productservice.controller;

import com.example.productservice.entity.ProductEntity;
import com.example.productservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/list-product")
    public List<ProductEntity> lstProduct(){
        return productService.getAllProduct();
    }
}
