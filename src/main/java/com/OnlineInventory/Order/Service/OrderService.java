package com.OnlineInventory.Order.Service;

import com.OnlineInventory.Order.Commons.ApiResponse;
import com.OnlineInventory.Order.Commons.BeanUtils;
import com.OnlineInventory.Order.DTO.BillingAddressDTO;
import com.OnlineInventory.Order.DTO.OrderDTO;
import com.OnlineInventory.Order.DTO.PaymentDetailDTO;
import com.OnlineInventory.Order.Model.*;
import com.OnlineInventory.Order.Repository.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    OrderAddressDetailRepository orderAddressDetailRepository;

    @Autowired
    BeanUtils beanUtils;

    public ApiResponse postOrder(OrderDTO orderDTO) {
        Long now =System.currentTimeMillis();
        Logger logger = LoggerFactory.getLogger(OrderService.class);
        logger.info("Posting Application ....");
        Order order = new Order();
        OrderAddressDetail orderAddressDetail= beanUtils.populateOrderAdressDetail(order,orderDTO);
        OrderDetail orderDetail=  beanUtils.populateOrderDetail(orderDTO, order);
        PaymentDetails paymentDetails= beanUtils.populatePaymentDetails(order, orderDTO);

        // Populating Order
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setOrderTotalAmount(orderDTO.getOrderTotal());
        order.setPaymentStatus(orderDTO.getPaymentStatus());
        order.setShippingMethod(orderDTO.getShippingMethod());
        order.setShippingAmount(orderDTO.getShippingAmt());
        order.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        order.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
        order.setDiscountCode(orderDTO.getCouponDetail().getCouponName());
        order.setDiscountType(orderDTO.getCouponDetail().getDiscountType());
        order.setCreateDate(new Timestamp(now));
        order.setOrderAddressDetails(Arrays.asList(orderAddressDetail));
        order.setOrderDetailList(Arrays.asList(orderDetail));
        order.setPaymentDetails(Arrays.asList(paymentDetails));

        try
        {
            orderRepository.save(order);
            logger.info("{  Order Id: "+order.getOrder_id().toString()+"  "+ "Status: SUCCESS"+"Timestamp: "+new Timestamp(System.currentTimeMillis())+"  }");
            return new ApiResponse(order.getOrder_id(),"SUCCESS", new Timestamp(System.currentTimeMillis()));
        }
        catch (Exception e)
        {
            logger.info("{  Timestamp:  "+new Timestamp( System.currentTimeMillis())+"  Status = Failed"+"  message="+e.getMessage()+"  }");
            return new ApiResponse(new Timestamp(System.currentTimeMillis()),"Failed",e.getMessage());
        }



    }




}
