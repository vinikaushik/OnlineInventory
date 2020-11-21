package com.inventory.order.service;

import java.util.Date;

import org.springframework.http.ResponseEntity;

import com.inventory.order.dto.CustomerAddressDTO;
import com.inventory.order.dto.OrderDTO;
import com.inventory.order.dto.OrderReturnItemsDTO;
import com.inventory.order.model.Order;

public interface OrderService {

    ResponseEntity<Object> postOrder(OrderDTO orderDTO);

    ResponseEntity<Order> getOrderById(Long id);

    ResponseEntity<Object> getOrderListID(int createdBy);

    ResponseEntity<Object> getOrderListForAdmin(Date startDate, Date endDate);

    ResponseEntity<Object> getOrderList(int createdBy, Date startDate, Date endDate);

    ResponseEntity<Object> postCustomerAddress(CustomerAddressDTO custAddDTO);

    ResponseEntity<Object> getCustomerAddress(int createdBy);
    
    ResponseEntity<Object> cancelOrderById(Long id);
    
    ResponseEntity<Object> returnOrder(OrderReturnItemsDTO returnDTO);

}
