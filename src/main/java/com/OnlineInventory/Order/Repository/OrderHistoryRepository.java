package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> {
}
