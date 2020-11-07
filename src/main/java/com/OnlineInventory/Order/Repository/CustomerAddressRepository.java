package com.OnlineInventory.Order.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineInventory.Order.Model.CustomerAddress;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long>{
	ArrayList<CustomerAddress> findAllByCreatedBy(int createdBy);
}
