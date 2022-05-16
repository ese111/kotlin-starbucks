package com.example.starbucks.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.starbucks.config.RestDocsConfiguration;
import com.example.starbucks.domain.CategoryType;
import com.example.starbucks.dto.CategoryResponse;
import com.example.starbucks.dto.CategoryTypeListResponse;
import com.example.starbucks.dto.CategoryWithProductResponse;
import com.example.starbucks.dto.ProductResponse;
import com.example.starbucks.service.CategoryService;
import java.util.List;
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
@WebMvcTest(CategoryController.class)
@DisplayName("CategoryController 클래스")
class CategoryControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CategoryService categoryService;

	@Test
	void 특정_카테고리의_서브_카테고리를_조회한다() throws Exception {
		//given
		CategoryType[] categoryTypes = CategoryType.values();

		given(categoryService.getSubCategories(CategoryType.DRINK))
			.willReturn(
				new CategoryTypeListResponse(categoryTypes,
					List.of(new CategoryResponse(1L, "콜드브루", "Cold brew", "image1"),
						new CategoryResponse(1L, "에스프레소", "Espresso", "image2"),
						new CategoryResponse(1L, "프라푸치노", "Frappuccino", "image3")
					)));

		//when
		ResultActions actions = mockMvc.perform(get("/categories?category-type=DRINK"));

		//then
		actions
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andDo(document("get-categories"));
	}

	@Test
	void 특정_카테고리의_이름과_카테고리의_포함된_상품을_조회한다() throws Exception {
		given(categoryService.findByIdWithProduct(1L))
			.willReturn(new CategoryWithProductResponse("에스프레소", List.of(
				new ProductResponse(1L, "http://~~~~ 1", "바닐라 플랫 화이트 1", "Vanilla Flat White 1",
					5600, true),
				new ProductResponse(2L, "http://~~~~ 2", "바닐라 플랫 화이트 2", "Vanilla Flat White 2",
					6600, false),
				new ProductResponse(3L, "http://~~~~ 3", "바닐라 플랫 화이트 3", "Vanilla Flat White 3",
					7600, false))));

		ResultActions perform = mockMvc.perform(get("/categories/1"));

		perform
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andDo(document("get-category-product"));
	}
}
