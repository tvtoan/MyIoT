package com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmId;

    @NotEmpty(message = "Not null")
    @Size(max = 50, message = "Max length 50 characters")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", unique = true)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

//    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
//    private List<SubFarm> subFarms;

    public Farm() {

    }

    public Farm(String description, Address address) {
        this.description = description;
        this.address = address;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
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

    //Check if this is for New of Update
    public boolean isNew() {
        return (this.farmId == null);
    }

//    public List<SubFarm> getSubFarms() {
//        return subFarms;
//    }
//
//    public void setSubFarms(List<SubFarm> subFarms) {
//        this.subFarms = subFarms;
//    }


    @Override
    public String toString() {
        return "Farm{" +
                "farmId=" + farmId +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", user=" + user +
                '}';
    }
}