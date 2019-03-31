package com.app.entity;

import javax.persistence.*;

@Entity
public class Crops {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cropsId;

    private String name;

    private String description;

    @OneToOne(mappedBy = "cropsTransaction")
    private TransactionFarm transactionFarm;


    public Crops(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getCropsId() {
        return cropsId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TransactionFarm getTransactionFarm() {
        return transactionFarm;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTransactionFarm(TransactionFarm transactionFarm) {
        this.transactionFarm = transactionFarm;
    }
}