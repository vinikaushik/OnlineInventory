package com.example.Order.Repository;

import com.example.Order.Model.CustomerDetail;
import com.example.Order.Model.OrderAddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail,Long> {
}
