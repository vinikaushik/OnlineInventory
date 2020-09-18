package com.OnlineInventory.Order.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore


    private String status;
    private Timestamp statusData;
    private Boolean notificationSent;
    private String createdBy;

    private Timestamp createdDate;
    private String updatedBy;
    private Timestamp lastUpdated;


    @ManyToOne
    @JoinColumn(name = "order_id" ,nullable=false)
    Order order;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "item_id" ,nullable=false)
    OrderItem item;

    public OrderHistory(Long id, Order order, OrderItem item, String status, Timestamp statusData, Boolean notificationSent, String createdBy, Timestamp createdDate, String updatedBy, Timestamp lastUpdated) {
        this.id = id;
        this.order = order;
        this.item = item;

        this.status = status;
        this.statusData = statusData;
        this.notificationSent = notificationSent;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.lastUpdated = lastUpdated;
    }

    public OrderHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem getItem() {
        return item;
    }

    public void setItem(OrderItem item) {
        this.item = item;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStatusData() {
        return statusData;
    }

    public void setStatusData(Timestamp statusData) {
        this.statusData = statusData;
    }

    public Boolean getNotificationSent() {
        return notificationSent;
    }

    public void setNotificationSent(Boolean notificationSent) {
        this.notificationSent = notificationSent;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
