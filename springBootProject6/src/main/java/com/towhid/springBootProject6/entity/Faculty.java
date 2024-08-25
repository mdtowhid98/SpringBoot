package com.towhid.springBootProject6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "Faculties")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int totalSeat;


// @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
// @JoinColumn(name = "depId")
//private Department department;



}
