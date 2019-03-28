package com.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class SubFarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private double area;

    @OneToMany(mappedBy = "subFarm", cascade = CascadeType.ALL)
    private List<TransactionFarm> transactionFarms;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Farm farm;

}