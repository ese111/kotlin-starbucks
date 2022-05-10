package com.example.starbucks.service;

import com.example.starbucks.domain.Product;
import com.example.starbucks.dto.ProductDetailDto;
import com.example.starbucks.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDetailDto getProductDetailById(Long id) {
        Product product = productRepository.findOne(id);
        return ProductDetailDto.of(product);
    }
}
