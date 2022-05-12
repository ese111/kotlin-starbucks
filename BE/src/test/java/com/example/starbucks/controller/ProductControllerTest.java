package com.example.starbucks.controller;

import com.example.starbucks.dto.ProductDetailDto;
import com.example.starbucks.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean private ProductService productService;

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