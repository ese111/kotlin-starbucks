package com.example.starbucks.controller;

import com.example.starbucks.config.RestDocsConfiguration;
import com.example.starbucks.domain.CategoryType;
import com.example.starbucks.dto.CategoryResponse;
import com.example.starbucks.dto.CategoryTypeListResponse;
import com.example.starbucks.service.OrderService;
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

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(RestDocsConfiguration.class)
@AutoConfigureRestDocs
@WebMvcTest(CategoryController.class)
@DisplayName("OrderController 클래스")
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
}
