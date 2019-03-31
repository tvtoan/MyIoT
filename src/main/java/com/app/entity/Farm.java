package com.app.entity;

import javax.persistence.*;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmId;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", unique = true)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Farm() {

    }

    public Farm(String description, Address address) {
        this.description = description;
        this.address = address;
    }

    public Long getFarmId() {
        return farmId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}