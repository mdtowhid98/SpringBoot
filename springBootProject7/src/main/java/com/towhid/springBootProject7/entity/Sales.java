package com.towhid.springBootProject7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "Sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String customerName;

    private Date salesDate;
    private int  totalPrice;
//    private String gender;
//    private Date dob;

    @ManyToOne
    @JoinColumn(name = "proId")
    private Products products;

}
