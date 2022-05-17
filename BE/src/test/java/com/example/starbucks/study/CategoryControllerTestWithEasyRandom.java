package com.example.starbucks.study;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.starbucks.controller.CategoryController;
import com.example.starbucks.domain.CategoryType;
import com.example.starbucks.dto.CategoryResponse;
import com.example.starbucks.dto.CategoryTypeListResponse;
import com.example.starbucks.dto.CategoryWithProductResponse;
import com.example.starbucks.dto.ProductResponse;
import com.example.starbucks.service.CategoryService;
import java.util.List;
import java.util.stream.Collectors;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(CategoryController.class)
class CategoryControllerTestWithEasyRandom {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CategoryService categoryService;

	EasyRandom generator;

	@BeforeEach
	void setUp() {
		generator = new EasyRandom();
	}

	@Test
	void 특정_카테고리의_서브_카테고리를_조회한다() throws Exception {
		List<CategoryResponse> categoryResponses = generator.objects(CategoryResponse.class, 3)
			.collect(Collectors.toList());

		given(categoryService.getSubCategories(CategoryType.DRINK))
			.willReturn(new CategoryTypeListResponse(CategoryType.values(), categoryResponses));

		//when
		ResultActions actions = mockMvc.perform(get("/categories?category-type=DRINK"));

		//then
		actions
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	void 특정_카테고리의_이름과_카테고리의_포함된_상품을_조회한다() throws Exception {
		given(categoryService.findByIdWithProduct(1L))
			.willReturn(new CategoryWithProductResponse("에스프레소",
				generator.objects(ProductResponse.class, 3).collect(Collectors.toList())));

		ResultActions perform = mockMvc.perform(get("/categories/1"));

		perform
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
}
