package com.app.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @OneToOne(mappedBy = "address")
    private Farm farm;

    public Address() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

}