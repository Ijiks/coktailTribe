package com.example.ed.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    @OneToMany
    private List<Products> orderContent;
    private Double costOfProduction;
    private Double proposedRetailPrice;
    private Double calculatedProfit;
}
