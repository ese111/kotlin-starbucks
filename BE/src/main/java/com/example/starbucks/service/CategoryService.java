package com.example.starbucks.service;

import com.example.starbucks.domain.Category;
import com.example.starbucks.domain.CategoryProduct;
import com.example.starbucks.domain.CategoryType;
import com.example.starbucks.dto.CategoryResponse;
import com.example.starbucks.dto.CategoryTypeListResponse;
import com.example.starbucks.dto.CategoryWithProductResponse;
import com.example.starbucks.dto.ProductResponse;
import com.example.starbucks.repository.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
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
        Category category = categoryRepository.findByIdWithProduct(id).orElseThrow();

        List<CategoryProduct> categoryProducts = category.getCategoryProducts();
        List<ProductResponse> products = categoryProducts.stream()
            .map(categoryProduct -> new ProductResponse(categoryProduct.getProduct()))
            .collect(Collectors.toList());

        for (int i = 0; i < categoryProducts.size(); i++) {
            if (i < 3) {
                products.get(i).setBest(true);
            }
        }
        return new CategoryWithProductResponse(category.getKoreanName(), products);
    }
}
