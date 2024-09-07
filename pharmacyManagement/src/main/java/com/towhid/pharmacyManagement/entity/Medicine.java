package com.towhid.pharmacyManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String manufacturer;
    private double price;
    private int quantity;
    private Date expiryDate;
    private Date manufacturerDate;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private MedicineGeneric category;


}
