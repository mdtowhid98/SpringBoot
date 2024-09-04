package com.towhid.hotelmanagement2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String roomType;

  private int adultNo;

  private int childNo;

  private float price;

  private boolean avilability;

  private int area;

  private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotelId")
    private  Hotel hotel;


}
