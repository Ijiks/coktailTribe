package com.example.ed.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentModel {
    private Long[] orderId;
    private Double amount;
    private String mobileNumber;
    private String paymentRef;
}
