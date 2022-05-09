package com.example.starbucks.domain;

import javax.persistence.*;

@Entity
public class EventProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    private Event event;

    @JoinColumn
    @ManyToOne
    private Product product;
}
