package com.example.starbucks.dto;

import com.example.starbucks.domain.Category;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CategoryDto {

    private Long id;
    private String koreanName;
    private String englishName;
    private String imageUrl;

    public CategoryDto(Long id, String koreanName, String englishName, String imageUrl) {
        this.id = id;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.imageUrl = imageUrl;
    }

    public static CategoryDto of(Category category) {
        return new CategoryDto(category.getId(), category.getKoreanName(),
                category.getEnglishName(), category.getImageUrl());
    }
}
