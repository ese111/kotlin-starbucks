package com.example.starbucks.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String koreanTitle;
    private String englishTitle;
    private String description;
    private int price;
    private int calorie;
    private int sugars;
    private int na;
    private int caffeine;
    private int fat;
    private String imageUrl;
    private int orderCount;
}
