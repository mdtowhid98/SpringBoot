//package com.towhid.pharmacyManagement.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "OrderItems")
//
//public class OrderItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private int quantity;
//    private double unitPrice;
//    private double totalPrice;
//
//
//    @ManyToOne
//    @JoinColumn(name = "medicineId")
//    private Medicine medicine;
//
//    @ManyToOne
//    @JoinColumn(name = "salesOrderId")
//    private SalesOrder salesOrder;
//
//
//
//
//}
