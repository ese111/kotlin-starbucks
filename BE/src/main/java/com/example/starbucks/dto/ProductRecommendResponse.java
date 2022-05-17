package com.example.starbucks.dto;

import com.example.starbucks.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductRecommendResponse {

    private Long id;
    private String imageUrl;
    private String name;

    public ProductRecommendResponse(Product product) {
        this.id = product.getId();
        this.imageUrl = product.getImageUrl();
        this.name = product.getKoreanName();
    }
}
