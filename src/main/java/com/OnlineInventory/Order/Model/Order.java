package com.OnlineInventory.Order.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="od_order")
public class Order {
    @OneToMany(mappedBy = "order",cascade = {CascadeType.ALL})
    List<OrderDetail> orderDetailList;

    @OneToMany(mappedBy = "order",cascade = {CascadeType.ALL})
    List<OrderHistory> orderHistory;

    @OneToMany(mappedBy = "order",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<OrderAddressDetail> orderAddressDetails;
//
    @OneToMany(mappedBy = "order",cascade = {CascadeType.ALL}   )
    List<PaymentDetails> paymentDetails;




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer orderStatus;
    private Double orderTotalAmount;
    private Double orderBaseAmount;
    private Double discountAmount;
    private Double shippingAmount;
    private Integer userType;
    private Integer paymentStatus;
    private Integer discountType;
    private String phone;
    private String email;
    private String discountCode;
    private Integer busyFlag;
    private String busyVoucherId;
    private Integer notificationType;
    private Integer shippingMethod;
    private String shippingId;
    private Integer createdBy;
    private Timestamp createDate;
    private Integer updatedBy;
    private Timestamp lastUpdate;


    public Order() {
    }

    public Order(Long id, Integer orderStatus, Double orderTotalAmount, Double orderBaseAmount, Double discountAmount, Double shippingAmount, Integer userType, Integer paymentStatus, Integer discountType, String phone, String email, String discountCode, Integer busyFlag, String busyVoucherId, Integer notificationType, Integer shippingMethod, String shippingId, Integer createdBy, Timestamp createDate, Integer updatedBy, Timestamp lastUpdate) {

        this.id = id;
        this.orderStatus = orderStatus;
        this.orderTotalAmount = orderTotalAmount;
        this.orderBaseAmount = orderBaseAmount;
        this.discountAmount = discountAmount;
        this.shippingAmount = shippingAmount;
        this.userType = userType;
        this.paymentStatus = paymentStatus;
        this.discountType = discountType;
        this.phone = phone;
        this.email = email;
        this.discountCode = discountCode;
        this.busyFlag = busyFlag;
        this.busyVoucherId = busyVoucherId;
        this.notificationType = notificationType;
        this.shippingMethod = shippingMethod;
        this.shippingId = shippingId;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.updatedBy = updatedBy;
        this.lastUpdate = lastUpdate;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public List<OrderHistory> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<OrderHistory> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public List<OrderAddressDetail> getOrderAddressDetails() {
        return orderAddressDetails;
    }

    public void setOrderAddressDetails(List<OrderAddressDetail> orderAddressDetails) {
        this.orderAddressDetails = orderAddressDetails;
    }

    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Double orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Double getOrderBaseAmount() {
        return orderBaseAmount;
    }

    public void setOrderBaseAmount(Double orderBaseAmount) {
        this.orderBaseAmount = orderBaseAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(Double shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Integer getBusyFlag() {
        return busyFlag;
    }

    public void setBusyFlag(Integer busyFlag) {
        this.busyFlag = busyFlag;
    }

    public String getBusyVoucherId() {
        return busyVoucherId;
    }

    public void setBusyVoucherId(String busyVoucherId) {
        this.busyVoucherId = busyVoucherId;
    }

    public Integer getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(Integer notificationType) {
        this.notificationType = notificationType;
    }

    public Integer getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(Integer shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
