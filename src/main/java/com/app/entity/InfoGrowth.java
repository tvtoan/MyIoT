package com.app.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class InfoGrowth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int infoGrowthId;

    private Date date;

    private int score;

    private String description;

    @ManyToOne
    @JoinColumn
    private TransactionFarm transactionFarm;

}