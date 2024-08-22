package com.towhid.springBootProject5.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @Column(nullable = false,unique = true)
   private String name;

    @Column(nullable = false)
   private int totalSeat;

    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "depId")
    private Department department;

}
