package com.example.Order.Repository;

import com.example.Order.Model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDetails,Long> {
}
