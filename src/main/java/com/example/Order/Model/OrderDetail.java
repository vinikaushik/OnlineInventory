package com.example.Order.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//

    private Integer itemStatus;
    private Double itemTotalAmount;
    private Integer quantity;
    private Double itemPrice;
    private Double taxAmount;
    private Integer discountType;
    private String discountCode;
    private Double discountAmount;
    private String itemComment;
    private String createdBy;
    private Timestamp createDate;
    private Integer updatedBy;
    private Timestamp lastUpdate;


    @ManyToOne
    @JoinColumn(name = "order_id" ,nullable=false)
    Order order;

    @ManyToOne
    @JoinColumn(name = "item_id" ,nullable=false)
    OrderItem item1;

    public OrderDetail() {
    }

    public OrderDetail(Long id, Integer itemStatus, Double itemTotalAmount, Integer quantity, Double itemPrice, Double taxAmount, Integer discountType, String discountCode, Double discountAmount, String itemComment, String createdBy, Timestamp createDate, Integer updatedBy, Timestamp lastUpdate, Order order, OrderItem item) {
        this.id = id;
        this.itemStatus = itemStatus;
        this.itemTotalAmount = itemTotalAmount;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
        this.taxAmount = taxAmount;
        this.discountType = discountType;
        this.discountCode = discountCode;
        this.discountAmount = discountAmount;
        this.itemComment = itemComment;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.updatedBy = updatedBy;
        this.lastUpdate = lastUpdate;
        this.order = order;
        this.item1 = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Double getItemTotalAmount() {
        return itemTotalAmount;
    }

    public void setItemTotalAmount(Double itemTotalAmount) {
        this.itemTotalAmount = itemTotalAmount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getItemComment() {
        return itemComment;
    }

    public void setItemComment(String itemComment) {
        this.itemComment = itemComment;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem getItem() {
        return item1;
    }

    public void setItem(OrderItem item) {
        this.item1 = item;
    }
}
