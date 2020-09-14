package com.example.Order.Repository;

import com.example.Order.Model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> {
}
