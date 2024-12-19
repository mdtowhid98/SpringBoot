package com.towhid.mySoftTask1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Registrations")

public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String presentAddress;

    @Column(nullable = false)
    private String permanentAddress;

}
