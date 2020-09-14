package com.example.Order.Repository;

import com.example.Order.Model.OrderAddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderAddressDetailRepository extends JpaRepository<OrderAddressDetail,Long> {
}
