package com.example.ed.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mpesaRef;
    private String status;
    private String paymentType;
    private String msisdn;
    private Double amount;
    private Double balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
