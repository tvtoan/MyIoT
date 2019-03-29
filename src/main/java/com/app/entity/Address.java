package com.app.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @OneToOne(mappedBy = "address")
    private Farm farm;

    public Address() {
    }
}