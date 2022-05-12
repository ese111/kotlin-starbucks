package com.example.starbucks.controller;

import com.example.starbucks.domain.CategoryType;
import com.example.starbucks.dto.CategoryTypeListResponse;
import com.example.starbucks.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/categories")
    public CategoryTypeListResponse getSubCategories(@RequestParam("category-type") String categoryType) {
        return orderService.getSubCategories(CategoryType.valueOf(categoryType));
    }
}
