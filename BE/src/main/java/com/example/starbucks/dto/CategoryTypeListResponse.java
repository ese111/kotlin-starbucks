package com.example.starbucks.dto;

import com.example.starbucks.domain.CategoryType;
import lombok.Data;

import java.util.List;

@Data
public class CategoryTypeListResponse {
    private CategoryType[] categoryTypes;
    private List<CategoryResponse> categories;

    public CategoryTypeListResponse(CategoryType[] categoryTypes, List<CategoryResponse> categories) {
        this.categoryTypes = categoryTypes;
        this.categories = categories;
    }

    public static CategoryTypeListResponse of(CategoryType[] categoryTypes, List<CategoryResponse> categories){
        return new CategoryTypeListResponse(categoryTypes, categories);
    }
}
