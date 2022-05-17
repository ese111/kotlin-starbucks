package com.example.starbucks.domain;

import javax.persistence.*;

@Entity
public class EventProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
