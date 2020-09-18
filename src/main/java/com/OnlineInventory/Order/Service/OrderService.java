package com.OnlineInventory.Order.Service;

import com.OnlineInventory.Order.Commons.ApiResponse;
import com.OnlineInventory.Order.DTO.BillingAddressDTO;
import com.OnlineInventory.Order.DTO.OrderDTO;
import com.OnlineInventory.Order.DTO.PaymentDetailDTO;
import com.OnlineInventory.Order.Model.*;
import com.OnlineInventory.Order.OrderApplication;
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


    public ApiResponse postOrder(OrderDTO orderDTO) {
        Logger logger = LoggerFactory.getLogger(OrderService.class);
        logger.info("Posting Application ....");
        Order order = new Order();
        OrderAddressDetail orderAddressDetail = new OrderAddressDetail();
        OrderDetail orderDetail = new OrderDetail();

        PaymentDetails paymentDetails = new PaymentDetails();
        Long now =System.currentTimeMillis();
        List<OrderItem> orderItems = orderDTO.getItems();
        BillingAddressDTO billingAddress = orderDTO.getAddress().getBillToAddress();
        BillingAddressDTO shippingAddress = orderDTO.getAddress().getShipToAddress();
        PaymentDetailDTO paymentDetailDTO = orderDTO.getPaymentDetail();




//        ?order.setPaymentDetails(Arrays.asList(orderAddressDetail));


        List<OrderDetail> orderDetails= new ArrayList<>();
        for(int i = 0; i <orderItems.size(); i++)
        {
            orderDetail.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
            orderDetail.setOrder(order);
            orderDetail.setItem(orderDTO.getItems().get(i));
            orderDetail.setCreateDate(new Timestamp(now));
            orderDetail.setLastUpdate(new Timestamp(now));
            orderDetails.add(orderDetail);
            orderDetail.setCreateDate(new Timestamp(now));
            orderDetail.setLastUpdate(new Timestamp(now));
        }

        orderDetail.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
        orderDetail.setItemStatus(orderDTO.getOrderStatus());






        orderAddressDetail.setBillToFirstName(billingAddress.getFirstName());
        orderAddressDetail.setBillToMiddleName(billingAddress.getMiddleName());
        orderAddressDetail.setBillToLastName(billingAddress.getLastName());
        orderAddressDetail.setBillToState(billingAddress.getState());
        orderAddressDetail.setBillToZipCode(billingAddress.getZipCode());
        orderAddressDetail.setBillToAddLine1(billingAddress.getAddressLine1());
        orderAddressDetail.setBillToAddLine2(billingAddress.getAddressLine2());
        orderAddressDetail.setBillToCity(billingAddress.getCity());
        orderAddressDetail.setBillToCountry(billingAddress.getCountry());
        orderAddressDetail.setBillToState(billingAddress.getState());

        orderAddressDetail.setShipToFirstName(shippingAddress.getFirstName());
        orderAddressDetail.setShipToMiddleName(shippingAddress.getMiddleName());
        orderAddressDetail.setShipToLastName(shippingAddress.getLastName());
        orderAddressDetail.setShipToState(shippingAddress.getState());
        orderAddressDetail.setShipToZipCode(shippingAddress.getZipCode());
        orderAddressDetail.setShipToAddLine1(shippingAddress.getAddressLine1());
        orderAddressDetail.setShipToAddLine2(shippingAddress.getAddressLine2());
        orderAddressDetail.setShipToCity(shippingAddress.getCity());
        orderAddressDetail.setShipToCountry(shippingAddress.getCountry());
        orderAddressDetail.setShipToState(shippingAddress.getState());
        orderAddressDetail.setOrder(order);
        orderAddressDetail.setCreatedDate(new Timestamp(now));
        orderAddressDetail.setLastUpdated(new Timestamp(now));

//
        paymentDetails.setPaymentType(paymentDetailDTO.getPaymentType());
        paymentDetails.setBankName(paymentDetailDTO.getBankName());
        paymentDetails.setAccountNumber(paymentDetailDTO.getAccountNo());
        paymentDetails.setIfscCode(paymentDetailDTO.getIfscCode());
        paymentDetails.setCardNumber(paymentDetailDTO.getCardNumber());
        paymentDetails.setCardExpiry(paymentDetailDTO.getCardExpiryDate());
        paymentDetails.setOrderTotalAmount(paymentDetailDTO.getTotalAmount());
        paymentDetails.setOrder(order);
        paymentDetails.setCreatedDate(new Timestamp(now));
        paymentDetails.setLastUpdated(new Timestamp(now));



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

        try{
            orderRepository.save(order);

        logger.info("{  Order Id: "+order.getId().toString()+"  "+ "Status: SUCCESS"+"Timestamp: "+new Timestamp(System.currentTimeMillis())+"  }");
        return new ApiResponse(order.getId(),"SUCCESS", new Timestamp(System.currentTimeMillis()));
        }
        catch (Exception e){
            logger.info("{  Timestamp:  "+new Timestamp( System.currentTimeMillis())+"  Status = Failed"+"  message="+e.getMessage()+"  }");

            return new ApiResponse(new Timestamp(System.currentTimeMillis()),"Failed",e.getMessage());
        }



    }
}
