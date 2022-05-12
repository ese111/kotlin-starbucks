package com.example.starbucks.service;

import com.example.starbucks.domain.Product;
import com.example.starbucks.dto.ProductDetailDto;
import com.example.starbucks.dto.ProductListDto;
import com.example.starbucks.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDetailDto getProductDetailById(Long id) {
        Product product = productRepository.findOne(id);
        return ProductDetailDto.of(product);
    }

    public List<ProductListDto> getPopularProduct(String sortBy, String orderBy) {
        return productRepository.getPopularProduct(sortBy, orderBy);
//                .stream().map(ProductListDto::of)
//                .collect(Collectors.toList());
    }
}
