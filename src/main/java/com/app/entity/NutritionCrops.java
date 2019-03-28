package com.app.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class NutritionCrops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Crops crops;

    @OneToMany(mappedBy = "nutritionCrops", cascade = CascadeType.ALL)
    private List<Fertilizer> fertilizers;

}