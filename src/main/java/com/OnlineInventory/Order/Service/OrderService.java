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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

//    @Autowired
//    OrderAddressDetailRepository orderAddressDetailRepository;

    @Autowired
    BeanUtils beanUtils;

    Logger logger = LoggerFactory.getLogger(OrderService.class);
    
    public ResponseEntity<Object> postOrder(OrderDTO orderDTO) {
        Long now =System.currentTimeMillis();
        
        logger.info("Posting Application ....");
        Order order = new Order();

        CustomerDetail customerDetail= beanUtils.saveCustomerDetails(orderDTO);
        List<OrderItem> orderItems = beanUtils.saveItem(orderDTO);
        OrderHistory orderHistory=  beanUtils.populateOrderHistory(order,orderDTO,orderItems.get(0));
        OrderAddressDetail orderAddressDetail= beanUtils.populateOrderAdressDetail(order,orderDTO);
        List<OrderDetail> orderDetail=  beanUtils.populateOrderDetail(orderDTO, order,orderItems);
        PaymentDetails paymentDetails= beanUtils.populatePaymentDetails(order, orderDTO);


        // Populating Order
        order.setOrderStatus(orderDTO.getOrderStatus());        
            order.setOrderTotalAmount(orderDTO.getPaymentDetail().getTotalPrice());
        order.setOrderBaseAmount(orderDTO.getOrderTotal());
        order.setCreatedBy(orderDTO.getCustomerDetail().getCustomerId().intValue());
        order.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
        order.setPhone(orderDTO.getCustomerDetail().getPhone());
        order.setShippingId(orderDTO.getShippingMethod().toString());
        order.setUpdatedBy(orderDTO.getCustomerDetail().getCustomerId().intValue());
        order.setEmail(orderDTO.getCustomerDetail().getEmail());
        order.setNotificationType(orderDTO.getNotificationId().intValue());
        order.setOrderTotalAmount(orderDTO.getOrderTotal());
        order.setPaymentStatus(orderDTO.getPaymentStatus());
        order.setShippingMethod(orderDTO.getShippingMethod());
        order.setShippingAmount(orderDTO.getShippingAmt());
        order.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        order.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
        order.setDiscountCode(orderDTO.getCouponDetail().getCouponName());
        order.setDiscountType(orderDTO.getCouponDetail().getDiscountType());
        order.setCreateDate(new Timestamp(now));
        order.setOrderAddressDetails(orderAddressDetail);
        order.setOrderDetailList(orderDetail);
        order.setPaymentDetails(Arrays.asList(paymentDetails));
        order.setOrderHistory(Arrays.asList(orderHistory));
        order.setDeliveryInstruction(orderDTO.getDeliveryInstruction());
        order.setCreateDate(new Timestamp(now));


        try
        {
            orderRepository.save(order);
            logger.info("{  Order Id: "+order.getOrder_id().toString()+"  "+ "Status: SUCCESS"+"Timestamp: "+new Timestamp(System.currentTimeMillis())+"  }");
            return ResponseEntity.ok(order.getOrder_id());//new ApiResponse(order.getOrder_id(),"SUCCESS", new Timestamp(System.currentTimeMillis()));
        }
        catch (Exception e)
        {
            logger.info("{  Timestamp:  "+new Timestamp( System.currentTimeMillis())+"  Status = Failed"+"  message="+e.getMessage()+"  }");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            		//new ApiResponse(new Timestamp(System.currentTimeMillis()),"Failed",e.getMessage());
        }



    }

	public ResponseEntity<Order> getOrderById(Long id) {
		logger.info("getting order by id"+id);
		Optional<Order> order = orderRepository.findById(id);
		if(order.isPresent()) {
			return ResponseEntity.ok(order.get()); //new ApiResponse<Order>(order,"SUCCESS",new Timestamp(System.currentTimeMillis()));
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);//new ApiResponse<Order>(null,"Order Id doesn't exsist",new Timestamp(System.currentTimeMillis()));
		
		
	}




}
