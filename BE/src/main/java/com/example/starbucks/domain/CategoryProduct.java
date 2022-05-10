package com.example.starbucks.domain;

import javax.persistence.*;

@Entity
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    private Category category;

    @JoinColumn
    @ManyToOne
    private Product product;
}
