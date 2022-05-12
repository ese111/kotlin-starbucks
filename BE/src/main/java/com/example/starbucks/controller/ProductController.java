package com.example.starbucks.controller;

import com.example.starbucks.dto.ProductDetailResponse;
import com.example.starbucks.dto.ProductListResponse;
import com.example.starbucks.dto.ProductRecommendResponse;
import com.example.starbucks.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/{id}")
    public ProductDetailResponse getProductDetailById(@PathVariable("id") Long id) {
        return productService.getProductDetailById(id);
    }

    @GetMapping("/products")
    public List<ProductListResponse> getPopularProduct (@RequestParam("sort-by") String sortBy,
                                                        @RequestParam(value = "order-by", required = false) String orderBy) {
        return productService.getPopularProduct(sortBy, orderBy);
    }
    @GetMapping("/products/recommend")
    public List<ProductRecommendResponse> getRecommendProducts() {
        return productService.findFiveRecommendProducts();
    }
}
