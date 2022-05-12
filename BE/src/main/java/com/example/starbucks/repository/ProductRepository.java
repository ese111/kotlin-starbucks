package com.example.starbucks.repository;

import com.example.starbucks.domain.Product;
import com.example.starbucks.dto.ProductListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final EntityManager em;

    public Product findOne(Long id) {
        return em.find(Product.class, id);
    }

    public List<ProductListDto> getPopularProduct(String sortBy, String orderBy) {
        return em.createQuery("select new com.example.starbucks.dto.ProductListDto (p.id, p.koreanTitle, p.imageUrl) from Product p order by :sortBy :orderBy", ProductListDto.class)
                .setMaxResults(5)
                .getResultList();
    }
}
