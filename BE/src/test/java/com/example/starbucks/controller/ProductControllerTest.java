package com.example.starbucks.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.starbucks.config.RestDocsConfiguration;
import com.example.starbucks.dto.ProductDetailResponse;
import com.example.starbucks.dto.ProductListResponse;
import com.example.starbucks.dto.ProductRecommendResponse;
import com.example.starbucks.service.ProductService;
import java.util.stream.Collectors;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@Import(RestDocsConfiguration.class)
@AutoConfigureRestDocs
@WebMvcTest(ProductController.class)
@DisplayName("ProductController 클래스")
class ProductControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ProductService productService;

	EasyRandom generator;

	@BeforeEach
	void setUp() {
		generator = new EasyRandom();
	}

	@Test
	void 랜덤으로_5개의_상품을_조회한다() throws Exception {
		given(productService.findFiveRecommendProducts())
			.willReturn(generator.objects(ProductRecommendResponse.class, 5)
				.collect(Collectors.toList()));

		ResultActions perform = mockMvc.perform(get("/products/recommend"));

		perform
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5)));
	}

	@Test
	void 상품_상세_정보를_조회한다() throws Exception {
		//given
		given(productService.getProductDetailById(1L))
			.willReturn(generator.nextObject(ProductDetailResponse.class));

		//when
		ResultActions actions = mockMvc.perform(get("/products/1"));

		//then
		actions
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void 인기_상품_리스트를_조회한다() throws Exception {
		//given
		given(productService.getPopularProduct("orderCount", "desc"))
			.willReturn(generator.objects(ProductListResponse.class, 5)
				.collect(Collectors.toList()));

		//when
		ResultActions actions = mockMvc.perform(get("/products?sort-by=orderCount&order-by=desc"));

		//then
		actions
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5)));
	}
}
