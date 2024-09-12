package com.towhid.pharmacyManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "SalesMedicines")
public class SalesMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String customername;

    private Date salesdate;

    private double totalprice;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicineId")
    private Medicine medicine;

}
