package com.example.starbucks.dto;

import com.example.starbucks.domain.CategoryType;
import lombok.Data;

import java.util.List;

@Data
public class CategoryTypeListDto {
    private CategoryType[] categoryTypes;
    private List<CategoryDto> categories;

    public CategoryTypeListDto(CategoryType[] categoryTypes, List<CategoryDto> categories) {
        this.categoryTypes = categoryTypes;
        this.categories = categories;
    }

    public static CategoryTypeListDto of(CategoryType[] categoryTypes, List<CategoryDto> categories){
        return new CategoryTypeListDto(categoryTypes, categories);
    }
}
