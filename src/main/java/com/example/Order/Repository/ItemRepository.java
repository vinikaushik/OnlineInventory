package com.example.Order.Repository;

import com.example.Order.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<OrderItem,Long> {
}
