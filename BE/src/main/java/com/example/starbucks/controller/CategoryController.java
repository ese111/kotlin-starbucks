package com.example.starbucks.controller;

import com.example.starbucks.domain.CategoryType;
import com.example.starbucks.dto.CategoryTypeListResponse;
import com.example.starbucks.dto.CategoryWithProductResponse;
import com.example.starbucks.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public CategoryTypeListResponse getSubCategories(@RequestParam("category-type") String categoryType) {
        return categoryService.getSubCategories(CategoryType.valueOf(categoryType));
    }
}
