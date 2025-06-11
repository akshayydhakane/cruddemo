package com.example.cruddemo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Userdetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userdetailid;

    @OneToOne
    @JoinColumn(name = "usermasterid")
    private Usermaster usermaster;

    private String firstname;
    private String lastname;
    private String designation;
    private boolean isActive;

    public void setIsActive(boolean active) {
    }
}
