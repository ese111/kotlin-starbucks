package com.example.starbucks.dto;

import com.example.starbucks.domain.Product;
import lombok.Data;

@Data
public class ProductListResponse {
    private Long id;
    private String koreanTitle;
    private String imageUrl;

    public ProductListResponse(Long id, String koreanTitle, String imageUrl) {
        this.id = id;
        this.koreanTitle = koreanTitle;
        this.imageUrl = imageUrl;
    }

    public static ProductListResponse of (Product product) {
        return new ProductListResponse(product.getId(), product.getKoreanName(), product.getImageUrl());
    }

}
