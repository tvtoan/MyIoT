package com.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Farm> farms;
}

