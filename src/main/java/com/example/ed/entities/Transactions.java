package com.example.ed.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionType;
    private Double openingBalance;
    private Double closingBalance;
    @ManyToOne
    private Payment payment;
    @ManyToOne
    private Orders order;
    private LocalDateTime createdAt;
}
