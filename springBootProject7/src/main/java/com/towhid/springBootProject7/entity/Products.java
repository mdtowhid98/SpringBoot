package com.towhid.springBootProject7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = true)
    private String name;

    private String photo;

    private int unitPrice;

    private int stock;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;



}
