package com.app.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class TransactionFarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionFarmId;

    private Date startDate;

    private Date endDate;

    private double production;

    private double sales;

    @ManyToOne
    @JoinColumn
    private SubFarm subFarm;

    @OneToMany(mappedBy = "transactionFarm", cascade = CascadeType.ALL)
    private List<InfoGrowth> infoGrowths;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Crops cropsTransaction;
}