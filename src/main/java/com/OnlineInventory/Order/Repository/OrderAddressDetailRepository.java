package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.Order;
import com.OnlineInventory.Order.Model.OrderAddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAddressDetailRepository extends JpaRepository<OrderAddressDetail, Long> {
}
