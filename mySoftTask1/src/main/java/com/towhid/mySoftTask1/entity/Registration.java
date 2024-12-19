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
    //    @Column(nullable = false,unique = true)
    private String name;
    private Date dob;
    private String mobile;
    private String gender;
    private String presentAddress;
    private String permanentAddress;

}
