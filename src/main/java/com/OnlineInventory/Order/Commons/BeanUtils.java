package com.OnlineInventory.Order.Commons;
import com.OnlineInventory.Order.DTO.*;
import com.OnlineInventory.Order.Model.*;
import com.OnlineInventory.Order.Repository.CustomerDetailRepository;
import com.OnlineInventory.Order.Repository.ItemRepository;
import com.OnlineInventory.Order.Repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeanUtils {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomerDetailRepository customerDetailRepository;
    @Autowired
    OrderHistoryRepository orderHistoryRepository;

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
    public  List<OrderItem>  saveItem(OrderDTO orderDTO){
       
        List<OrderItem> orderItems = new ArrayList<>();
        for(ItemDTO itemDTO : orderDTO.getItems())
        {
        	 OrderItem orderItem = new OrderItem();
            orderItem.setId(itemDTO.getItemId());
            orderItem.setItemSize(itemDTO.getItemSize());
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setPrice(itemDTO.getPrice());
            orderItems.add(orderItem);
        }
        return  orderItems;
    }
    public List<OrderDetail> populateOrderDetail(OrderDTO orderDTO, Order order, List<OrderItem> orderItems) {
       
        List<OrderDetail> orderDetails= new ArrayList<>();

        for(OrderItem orderItem : orderItems) {
        	 OrderDetail orderDetail = new OrderDetail();

        	orderDetail.setCreateDate(new Timestamp(now));
            orderDetail.setLastUpdate(new Timestamp(now));
            orderDetail.setItem(orderItem);
            orderDetail.setItemTotalAmount(orderItem.getPrice()*orderItem.getQuantity());
            orderDetail.setQuantity(orderItem.getQuantity());
            orderDetail.setItemPrice(orderItem.getPrice());
            orderDetail.setCreateDate(new Timestamp(now));
            orderDetail.setLastUpdate(new Timestamp(now));
            orderDetail.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
            orderDetail.setOrder(order);
            orderDetail.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
            orderDetail.setItemStatus(orderDTO.getOrderStatus());
            orderDetails.add(orderDetail);

        }
        return orderDetails;
    }

    public CustomerDetail saveCustomerDetails(OrderDTO orderDTO){
        CustomerDetail customerDetail = new CustomerDetail();
        CustomerDetailDTO customerDetailDTO = orderDTO.getCustomerDetail();

        customerDetail.setCustomerId(customerDetailDTO.getCustomerId());
        customerDetail.setFirstName(customerDetailDTO.getFirstName());
        customerDetail.setMiddleName(customerDetailDTO.getMiddleName());
        customerDetail.setLastName(customerDetailDTO.getLastName());
        customerDetail.setPhone(customerDetailDTO.getPhone());
        customerDetail.setEmail(customerDetailDTO.getEmail());
        customerDetail.setAddressLine1(customerDetailDTO.getAddressLine1());
        customerDetail.setAddressLine2(customerDetailDTO.getAddressLine2());
        customerDetail.setCity(customerDetailDTO.getCity());
        customerDetail.setZipCode(customerDetailDTO.getZipCode());
        customerDetail.setCountry(customerDetailDTO.getCountry());
        customerDetail.setState(customerDetailDTO.getState());
//        customerDetailRepository.save(customerDetail);

            return customerDetail;
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

    public OrderHistory populateOrderHistory (Order order , OrderDTO orderDTO, OrderItem orderItem)
    {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrder(order);
        orderHistory.setItem(orderItem);
        orderHistory.setCreatedDate(new Timestamp(now));
//        orderHistory.setUpdatedBy(new Timestamp(now));
        orderHistory.setNotificationSent(orderDTO.getNotificationId()!=null);
        orderHistory.setLastUpdated(new Timestamp(now));
        orderHistory.setStatusDate(new Timestamp(now));
//        orderHistoryRepository.save(orderHistory);
        return orderHistory;
    }
}
