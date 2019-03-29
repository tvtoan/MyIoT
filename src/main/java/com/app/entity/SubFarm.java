package com.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SubFarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subFarmId;

    private String description;

    private double area;

    @OneToMany(mappedBy = "subFarm", cascade = CascadeType.ALL)
    private List<TransactionFarm> transactionFarms;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Farm farm;

}