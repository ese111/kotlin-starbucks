package com.example.starbucks.repository;

import com.example.starbucks.domain.Category;
import com.example.starbucks.domain.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Category, Long> {

    List<Category> findByType(@Param("type") CategoryType type);
}
