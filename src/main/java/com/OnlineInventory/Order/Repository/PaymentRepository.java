package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentDetails,Long> {
}
