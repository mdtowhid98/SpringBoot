package com.towhid.hotelmanagement2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    private  String address;
    private  String rating;
    private  float minPrice;
    private  float maxPrice;
    private  String image;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "laoctionId")
    private  Location location;



}
