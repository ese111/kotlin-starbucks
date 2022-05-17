package com.example.starbucks.domain;

import javax.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
