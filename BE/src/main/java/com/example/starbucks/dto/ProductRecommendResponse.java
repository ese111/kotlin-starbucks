package com.example.starbucks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductRecommendResponse {

    private Long id;
    private String imageUrl;
    private String name;
}
