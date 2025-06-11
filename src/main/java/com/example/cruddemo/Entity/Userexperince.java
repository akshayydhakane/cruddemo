package com.example.cruddemo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Userexperince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrexperinceId;

    @ManyToOne
    @JoinColumn(name = "usermasterid")
    private Usermaster usermaster;

    private String experincename;

}
