package com.example.ed.services;

import com.example.ed.entities.Orders;
import com.example.ed.entities.Payment;
import com.example.ed.entities.Products;
import com.example.ed.models.OrderModel;
import com.example.ed.models.PaymentModel;
import com.example.ed.models.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Products> getAllProducts();

    Products createProduct(ProductModel product);

    List<Orders> getAllOrder();

    Orders processOrder(OrderModel order_);

    void saveProduct(Products product);

    PaymentModel makePayment(PaymentModel paymentModel);

    Payment findPaymentById(Long id);

    Optional<Payment> findPaymentByRef(String ref);

    List<Payment> findAllPayments();
}


