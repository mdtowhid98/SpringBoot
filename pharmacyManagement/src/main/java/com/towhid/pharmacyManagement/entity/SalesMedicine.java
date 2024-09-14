//package com.towhid.pharmacyManagement.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.sql.Date;
//import java.util.List;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "SalesMedicines")
//public class SalesMedicine {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String customername;
//
//    private Date salesdate;
//
//    private double totalprice;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "salesMedicine", cascade = CascadeType.ALL)
//    private List<Medicine> medicines;
//
//}
