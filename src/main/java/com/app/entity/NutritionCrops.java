package com.app.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NutritionCrops {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nutritionCropsId;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "cropsId", nullable = false)
    private Crops crops;

    public NutritionCrops() {
    }

    public NutritionCrops(Date date) {
        this.date = date;
    }

    public Long getNutritionCropsId() {
        return nutritionCropsId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Crops getCrops() {
        return crops;
    }

    public void setCrops(Crops crops) {
        this.crops = crops;
    }
}