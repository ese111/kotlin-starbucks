package com.example.starbucks.controller;

import com.example.starbucks.dto.ProductDetailDto;
import com.example.starbucks.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/{id}")
    public ProductDetailDto getProductDetailById(@PathVariable("id") Long id) {
        return productService.getProductDetailById(id);
    }

}
