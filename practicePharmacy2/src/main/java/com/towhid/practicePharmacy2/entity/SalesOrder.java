package com.towhid.practicePharmacy2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "SalesOrders")

public class SalesOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "pharmacistId")
    private Pharmacist pharmacist;

    private Date orderDate;
    private double totalAmount;

//    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
//    private List<OrderItem> orderItems;


}
