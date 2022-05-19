package com.example.starbucks.service;

import com.example.starbucks.domain.Order;
import com.example.starbucks.domain.Product;
import com.example.starbucks.repository.OrderRepository;
import com.example.starbucks.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void order(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();

        Order order = new Order(product, product.getPrice());
        orderRepository.save(order);
    }
}
