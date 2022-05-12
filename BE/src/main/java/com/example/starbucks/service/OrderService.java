package com.example.starbucks.service;

import com.example.starbucks.domain.CategoryType;
import com.example.starbucks.dto.CategoryTypeListDto;
import com.example.starbucks.dto.CategoryDto;
import com.example.starbucks.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public CategoryTypeListDto getSubCategories(CategoryType type) {
        CategoryType[] categoryTypes = CategoryType.values();

        List<CategoryDto> categories = orderRepository.findByType(type)
                .stream().map(CategoryDto::of)
                .collect(Collectors.toList());

        return CategoryTypeListDto.of(categoryTypes, categories);
    }

}
