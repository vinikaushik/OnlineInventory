package com.example.Order.Service;

import com.example.Order.Commons.ApiResponse;
import com.example.Order.Commons.Status;
import com.example.Order.DTO.BillingAddressDTO;
import com.example.Order.DTO.ItemDTO;
import com.example.Order.DTO.OrderDTO;
import com.example.Order.DTO.PaymentDetailDTO;
import com.example.Order.Model.*;
import com.example.Order.Model.OrderHistory;
import com.example.Order.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        Order order = new Order();
        OrderAddressDetail orderAddressDetail = new OrderAddressDetail();
        OrderDetail orderDetail = new OrderDetail();

        PaymentDetails paymentDetails = new PaymentDetails();
        Long now =System.currentTimeMillis();
        List<OrderItem> orderItems = orderDTO.getItems();
        BillingAddressDTO billingAddress = orderDTO.getAddress().getBillToAddress();
        BillingAddressDTO shippingAddress = orderDTO.getAddress().getShipToAddress();
        PaymentDetailDTO paymentDetailDTO = orderDTO.getPaymentDetail();

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

//        orderDetail.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
//        orderDetail.setItemStatus();
//        orderDetail.setItemStatus(orderDTO.getItems());





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

        orderRepository.save(order);
        orderAddressDetailRepository.save(orderAddressDetail);
        paymentRepository.save(paymentDetails);
        orderDetailRepository.saveAll(orderDetails);
        return new ApiResponse(Status.Status_Ok,"Posted Sucessfully", order);



    }
}
