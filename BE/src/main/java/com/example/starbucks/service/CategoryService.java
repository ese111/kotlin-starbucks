package com.example.starbucks.service;

import com.example.starbucks.domain.CategoryType;
import com.example.starbucks.dto.CategoryTypeListResponse;
import com.example.starbucks.dto.CategoryResponse;
import com.example.starbucks.dto.CategoryWithProductResponse;
import com.example.starbucks.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryTypeListResponse getSubCategories(CategoryType type) {
        CategoryType[] categoryTypes = CategoryType.values();

        List<CategoryResponse> categories = categoryRepository.findByType(type)
                .stream().map(CategoryResponse::of)
                .collect(Collectors.toList());

        return CategoryTypeListResponse.of(categoryTypes, categories);
    }

    public CategoryWithProductResponse findByIdWithProduct(Long id) {
        return null;
    }
}
