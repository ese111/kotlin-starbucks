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
        given(productService.findFiveRecommendProducts())
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
            .andExpect(jsonPath("$", hasSize(5)));
    }

    @Test
    void 상품_상세_정보를_조회한다() throws Exception {
        //given
        given(productService.getProductDetailById(1L))
            .willReturn(new ProductDetailResponse(1L, "카페라떼", "Caffe Latte",
                "대표적인 카페 라떼", 5000,110,9,8,75,6,
                69,"Latteurl"));

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
                .willReturn(List.of(
                        new ProductListResponse(1L, "카페라떼", "Latteurl"),
                        new ProductListResponse(2L, "콜드브루", "imageurl"),
                        new ProductListResponse(3L, "바닐라 크림 프라푸치노", "imageurl"),
                        new ProductListResponse(4L, "쿨라임 피지오", "imageurl"),
                        new ProductListResponse(5L, "카페 아메리카노", "americanourl")
                        )
                );

        //when
        ResultActions actions = mockMvc.perform(get("/products?sort-by=orderCount&order-by=desc"));

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(5)));
    }
}
