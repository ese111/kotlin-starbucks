package com.example.starbucks.dto;

import com.example.starbucks.domain.Category;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryWithProductResponse {
	private String categoryName;
	private List<ProductResponse> products;

	public CategoryWithProductResponse(Category category) {
		categoryName = category.getKoreanName();
		products = category.getCategoryProducts().stream()
			.map(categoryProduct -> new ProductResponse(categoryProduct.getProduct()))
			.collect(Collectors.toList());
	}
}
