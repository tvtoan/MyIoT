package com.app.entity;

import javax.persistence.*;

@Entity
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fertilizerId;

    private String description;

    @ManyToOne
    @JoinColumn(name = "nutritionCropsId", nullable = false)
    private NutritionCrops nutritionCrops;

    public Fertilizer() {
    }

    public Fertilizer(String description) {
        this.description = description;
    }

    public Long getFertilizerId() {
        return fertilizerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NutritionCrops getNutritionCrops() {
        return nutritionCrops;
    }

    public void setNutritionCrops(NutritionCrops nutritionCrops) {
        this.nutritionCrops = nutritionCrops;
    }
}