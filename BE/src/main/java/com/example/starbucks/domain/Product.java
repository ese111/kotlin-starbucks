package com.example.starbucks.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn
    private Order order;

    private String koreanName;
    private String englishName;
    private String description;
    private int price;
    private int calorie;
    private int sugars;
    private int na;
    private int caffeine;
    private int fat;
    private int protein;
    private String imageUrl;
    private int orderCount;
}
