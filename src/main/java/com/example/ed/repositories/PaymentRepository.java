package com.example.ed.repositories;

import com.example.ed.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    @Override
    Optional<Payment> findById(Long aLong);

    Optional<Payment> findByMpesaRef(String ref);
}
