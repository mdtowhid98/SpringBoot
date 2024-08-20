package com.example.springBootProject3.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String cell;
    private String gender;
    private Date dob;


}

