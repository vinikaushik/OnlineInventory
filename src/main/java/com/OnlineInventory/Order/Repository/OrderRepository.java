package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
