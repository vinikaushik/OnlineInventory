package com.OnlineInventory.Order.DTO;

public class ItemDTO {
    Long id;
    String itemSize;
    Integer quantity;
    Double price;
    Double tax;
    String couponCode;// order k table
    Integer discountType;
    Double couponAmount;
    String itemTotal;
    String status;

    public ItemDTO() {
    }

    public ItemDTO(Long id, String itemSize, Integer quantity, Double price, Double tax, String couponCode, Integer discountType, Double couponAmount, String itemTotal, String status) {
        this.id = id;
        this.itemSize = itemSize;
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.couponCode = couponCode;
        this.discountType = discountType;
        this.couponAmount = couponAmount;
        this.itemTotal = itemTotal;
        this.status = status;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(String itemTotal) {
        this.itemTotal = itemTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
