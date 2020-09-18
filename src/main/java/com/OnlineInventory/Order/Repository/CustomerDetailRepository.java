package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail,Long> {
}
