package com.example.starbucks.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.starbucks.config.RestDocsConfiguration;
import com.example.starbucks.dto.ProductDetailDto;
import com.example.starbucks.dto.ProductRecommendResponse;
import com.example.starbucks.service.ProductService;
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
@WebMvcTest(ProductController.class)
@DisplayName("ProductController 클래스")
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    void 랜덤으로_5개의_상품을_조회한다() throws Exception {
        given(productService.findRecommend())
            .willReturn(List.of(
                new ProductRecommendResponse(1L, "http://~~~", "랜덤 상품1"),
                new ProductRecommendResponse(2L, "http://~~~", "랜덤 상품2"),
                new ProductRecommendResponse(3L, "http://~~~", "랜덤 상품3"),
                new ProductRecommendResponse(4L, "http://~~~", "랜덤 상품4"),
                new ProductRecommendResponse(5L, "http://~~~", "랜덤 상품5")));

        ResultActions perform = mockMvc.perform(get("/products/recommend"));

        perform
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(5)))
            .andDo(document("create-event"));
    }

    @Test
    void 상품_상세_정보를_조회한다() throws Exception {
        //given
        given(productService.getProductDetailById(1L))
            .willReturn(new ProductDetailDto(1L, "나이트로 바닐라 크림", "Nitro Vanilla Cream",
                "부드러운 목넘김", 5900,75,10,20,245,1,
                3,"imageurl"));

        //when
        ResultActions actions = mockMvc.perform(get("/prodcuts/1"));

        //then

    }

    @Test
    void 인기_상품_리스트를_보낸다() throws Exception {

        //given

        //when

        //then

    }
}
