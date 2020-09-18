package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<OrderItem,Long> {
}
