package com.app.entity;

import javax.persistence.*;

@Entity
public class SubFarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subFarmId;

    private String description;

    private double area;

    @ManyToOne
    @JoinColumn(name = "farmId", nullable = false)
    private Farm farm;

}