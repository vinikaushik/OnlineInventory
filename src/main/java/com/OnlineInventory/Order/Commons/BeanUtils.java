package com.OnlineInventory.Order.Commons;
import com.OnlineInventory.Order.DTO.BillingAddressDTO;
import com.OnlineInventory.Order.DTO.ItemDTO;
import com.OnlineInventory.Order.DTO.OrderDTO;
import com.OnlineInventory.Order.DTO.PaymentDetailDTO;
import com.OnlineInventory.Order.Model.*;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeanUtils {
    Long now =System.currentTimeMillis();

    public OrderAddressDetail populateOrderAdressDetail(Order order,OrderDTO orderDTO) {
        BillingAddressDTO billingAddress = orderDTO.getAddress().getBillToAddress();
        BillingAddressDTO shippingAddress = orderDTO.getAddress().getShipToAddress();
        OrderAddressDetail orderAddressDetail = new OrderAddressDetail();
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
        return  orderAddressDetail;
    }
    public OrderDetail populateOrderDetail(OrderDTO orderDTO, Order order) {
        OrderDetail orderDetail = new OrderDetail();
        List<OrderDetail> orderDetails= new ArrayList<>();
        for(OrderItem orderItem : orderDTO.getItems())
        {
            orderDetail.setItem(orderItem);

        }
        orderDetail.setCreateDate(new Timestamp(now));
        orderDetail.setLastUpdate(new Timestamp(now));
        orderDetails.add(orderDetail);
        orderDetail.setCreateDate(new Timestamp(now));
        orderDetail.setLastUpdate(new Timestamp(now));
        orderDetail.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
        orderDetail.setOrder(order);
        orderDetail.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
        orderDetail.setItemStatus(orderDTO.getOrderStatus());
        return  orderDetail;
    }
    public PaymentDetails populatePaymentDetails(Order order , OrderDTO orderDTO) {

        PaymentDetailDTO paymentDetailDTO = orderDTO.getPaymentDetail();
        PaymentDetails paymentDetails = new PaymentDetails();
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
        return paymentDetails;
    }

}
