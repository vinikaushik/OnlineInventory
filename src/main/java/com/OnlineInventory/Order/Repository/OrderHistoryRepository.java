package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> {
}
