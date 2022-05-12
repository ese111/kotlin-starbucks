package com.example.starbucks.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryType type;

    private String koreanName;
    private String englishName;
    private String imageUrl;

}
