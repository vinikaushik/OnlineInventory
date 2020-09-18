package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.OrderAddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderAddressDetailRepository extends JpaRepository<OrderAddressDetail,Long> {
}
