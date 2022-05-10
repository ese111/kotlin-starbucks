package com.example.starbucks.repository;

import com.example.starbucks.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final EntityManager em;

    public Product findOne(Long id) {
        return em.find(Product.class, id);
    }
}
