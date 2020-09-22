package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetails,Long> {
}
