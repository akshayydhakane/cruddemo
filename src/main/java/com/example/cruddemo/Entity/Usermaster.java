package com.example.cruddemo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Usermaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usermasterid;
    private String email;
    private String password;
    private boolean isActive;
    private LocalDateTime createdAt =LocalDateTime.now(); ;

    @OneToOne(mappedBy = "usermaster", cascade = CascadeType.ALL)
    private Userdetail userdetail;

    @OneToMany(mappedBy = "usermaster", cascade = CascadeType.ALL)
    private List<Userexperince> experiences = new ArrayList<>();

    public void setIsActive(boolean active) {
    }
}
