package com.example.starbucks.dto;

import com.example.starbucks.domain.Product;
import lombok.Data;

@Data
public class ProductListDto {
    private Long id;
    private String koreanTitle;
    private String imageUrl;

    public ProductListDto(Long id, String koreanTitle, String imageUrl) {
        this.id = id;
        this.koreanTitle = koreanTitle;
        this.imageUrl = imageUrl;
    }

    public static ProductListDto of (Product product) {
        return new ProductListDto(product.getId(), product.getKoreanTitle(), product.getImageUrl());
    }

}
