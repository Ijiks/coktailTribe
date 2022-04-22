package com.example.ed.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    private Double costOfProduction;
    private Double proposedRetailPrice;
    private Double balance;
    private Double calculatedProfit;
    @Lob
    @Column(name="CONTENT", length=800)
    private String orderContent;
    private LocalDateTime createdAt;
    private String status;
}
