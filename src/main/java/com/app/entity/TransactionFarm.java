package com.app.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TransactionFarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionFarmId;

    private Date startDate;

    private Date endDate;

    private double production;

    private double sales;

    @ManyToOne
    @JoinColumn(name = "subFarmId")
    private SubFarm subFarm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cropsId", unique = true)
    private Crops cropsTransaction;
}