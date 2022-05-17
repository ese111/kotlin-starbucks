package com.example.starbucks.dto;

import com.example.starbucks.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductResponse {
	private Long id;
	private String imageUrl;
	private String koreanName;
	private String englishName;
	private int price;
	private boolean best;

	public ProductResponse(Product product) {
		this.id = product.getId();
		this.imageUrl = product.getImageUrl();
		this.koreanName = product.getKoreanName();
		this.englishName = product.getEnglishName();
		this.price = product.getPrice();
	}

	public void setBest(boolean best) {
		this.best = best;
	}
}
