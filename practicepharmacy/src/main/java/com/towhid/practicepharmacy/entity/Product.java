package com.towhid.practicepharmacy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")


public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;

    private String photo;

    private int stock;

    private int quantity;
    private int unitprice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "salesId")
//    private Sales sales;

    
}
