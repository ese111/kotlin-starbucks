package com.example.starbucks.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.example.starbucks.domain.Product;
import com.example.starbucks.dto.ProductRecommendResponse;
import com.example.starbucks.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ProductService 클래스")
class ProductServiceTest {

	ProductService productService;
	ProductRepository productRepository;

	@BeforeEach
	void setUp() {
		productRepository = mock(ProductRepository.class);
		productService = new ProductService(productRepository);
	}

	@Test
	void 만약_리파지토리에서_조회한_상품이_5개_이상이라면_5개의_상품_정보만_반환한다() {
		given(productRepository.findAll())
			.willReturn(createEmptyProducts(10));

		List<ProductRecommendResponse> result = productService.findFiveRecommendProducts();

		assertThat(result.size()).isEqualTo(5);
	}

	@Test
	void 만약_리파지토리에서_조회한_상품이_5개_미만이라면_조회한_상품의_개수만큼_반환한다() {
		given(productRepository.findAll())
			.willReturn(createEmptyProducts(3));

		List<ProductRecommendResponse> result = productService.findFiveRecommendProducts();

		assertThat(result.size()).isEqualTo(3);
	}

	private List<Product> createEmptyProducts(int count) {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			products.add(new Product());
		}
		return products;
	}
}
