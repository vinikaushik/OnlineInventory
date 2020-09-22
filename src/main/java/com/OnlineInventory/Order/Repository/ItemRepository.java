package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<OrderItem,Long> {
}
