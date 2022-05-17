package com.example.starbucks.dto;

import com.example.starbucks.domain.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailResponse {
    private Long id;
    private String koreanName;
    private String englishName;
    private String description;
    private int price;
    private int calorie;
    private int sugars;
    private int na;
    private int caffeine;
    private int fat;
    private int protein;
    private String imageUrl;

    public ProductDetailResponse(Long id, String koreanName, String englishName, String description, int price, int calorie, int sugars, int na, int caffeine, int fat, int protein, String imageUrl) {
        this.id = id;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.description = description;
        this.price = price;
        this.calorie = calorie;
        this.sugars = sugars;
        this.na = na;
        this.caffeine = caffeine;
        this.fat = fat;
        this.protein = protein;
        this.imageUrl = imageUrl;
    }

    public static ProductDetailResponse of (Product product) {
        return new ProductDetailResponse(product.getId(), product.getKoreanName(), product.getEnglishName(),
                product.getDescription(), product.getPrice(), product.getCalorie(), product.getSugars(),
                product.getNa(), product.getCaffeine(), product.getFat(), product.getProtein(), product.getImageUrl());
    }
}
