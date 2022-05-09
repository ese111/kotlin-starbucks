package com.example.starbucks.domain;

import javax.persistence.*;

@Entity
public class SubCategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    private SubCategory subCategory;

    @JoinColumn
    @ManyToOne
    private Product product;
}
