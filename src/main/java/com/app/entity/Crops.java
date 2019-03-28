package com.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Crops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @OneToOne(mappedBy = "cropsTransaction")
    private TransactionFarm transactionFarm;

    @OneToMany(mappedBy = "crops", cascade = CascadeType.ALL)
    private List<NutritionCrops> nutritionCrops;
}