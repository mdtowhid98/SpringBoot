package com.towhid.practicePharmacy2.entity;

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
    private double stock;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private MedicineGeneric generic;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "salesMedicineId")
    private SalesMedicine salesMedicine;

}
