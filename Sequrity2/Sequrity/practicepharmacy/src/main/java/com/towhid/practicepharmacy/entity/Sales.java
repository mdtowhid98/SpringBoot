package com.towhid.practicepharmacy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customername;
    private Date salesdate;
    private int totalprice;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    private List<SalesProduct> salesProducts;


}
