package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
