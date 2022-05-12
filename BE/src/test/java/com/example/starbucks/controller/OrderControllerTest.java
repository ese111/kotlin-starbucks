package com.example.starbucks.controller;

import com.example.starbucks.config.RestDocsConfiguration;
import com.example.starbucks.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Import(RestDocsConfiguration.class)
@AutoConfigureRestDocs
@WebMvcTest(OrderController.class)
@DisplayName("OrderController 클래스")
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderService orderService;

//    @Test
//    void 특정_카테고리의_서브_카테고리를_조회한다() throws Exception {
//        //given
//        given(orderService.getSubCategories(CategoryType.DRINK))
//                .willReturn(List.of(
//                        new CategoryResponseDto(1L, "콜드브루", "Cold brew", "image1"),
//                        new CategoryResponseDto(2L, "에스프레소", "Espresso", "image2"),
//                        new CategoryResponseDto(3L, "프라푸치노", "Frappuccino", "image3")
//                ));
//
//        //when
//        ResultActions actions = mockMvc.perform(get("/categories?category-type=DRINK"));
//
//        //then
//        actions
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(3)))
//                .andDo(document("get-categories"));
//    }
}
