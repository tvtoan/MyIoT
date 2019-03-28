package com.app.entity;

import javax.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private NutritionCrops nutritionCrops;
}