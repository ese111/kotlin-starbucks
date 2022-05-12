package com.example.starbucks.service;

import com.example.starbucks.domain.Product;
import com.example.starbucks.dto.ProductDetailResponse;
import com.example.starbucks.dto.ProductRecommendResponse;
import com.example.starbucks.dto.ProductListResponse;
import com.example.starbucks.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDetailResponse getProductDetailById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return ProductDetailResponse.of(product);
    }

    public List<ProductRecommendResponse> findFiveRecommendProducts() {
        List<Product> products = productRepository.findAll();

        Collections.shuffle(products);
        List<ProductRecommendResponse> productRecommendResponses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i == products.size()) {
                break;
            }
            productRecommendResponses.add(new ProductRecommendResponse(products.get(i)));
        }
        return productRecommendResponses;
    }

    public List<ProductListResponse> getPopularProduct(String sortBy, String orderBy) {
        Sort sort = Sort.by(sortBy);
        if ("desc".equals(orderBy)) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(0,5, sort);

        return productRepository.findAll(pageable).getContent()
                .stream().map(ProductListResponse::of)
                .collect(Collectors.toList());
    }
}
