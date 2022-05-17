package com.example.starbucks.repository;

import com.example.starbucks.domain.Category;
import com.example.starbucks.domain.CategoryType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByType(@Param("type") CategoryType type);

    @Query("select c from Category c "
        + "join fetch c.categoryProducts cp "
        + "join fetch cp.product p "
        + "where c.id = :id "
        + "order by p.orderCount desc ")
    Optional<Category> findByIdWithProduct(@Param("id") Long id);
}
