package com.app.entity;

import javax.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fertilizerId;

    private String description;

    @ManyToOne
    @JoinColumn(nullable = false)
    private NutritionCrops nutritionCrops;
}