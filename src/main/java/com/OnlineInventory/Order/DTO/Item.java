//package com.example.Order.DTO;
//
//public class Items {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String itemSize;
//    private Integer quantity;
//    private Integer price;
//    private String tax;
//    private String couponCode;
//    private String discountType;
//    private String couponAmt;
//    private String itemTotal;
//    private String itemStatus;
//
//    @JsonManagedReference
//    @OneToMany(mappedBy = "items", cascade = CascadeType.ALL)
//    private Set<ItemOrder> itemOrders = new HashSet<>();;
//
//    public Items() {
//    }
//
//    public Items(String itemSize, Integer quantity, Integer price, String tax, String couponCode, String discountType, String couponAmt, String itemTotal, String itemStatus) {
//        this.itemSize = itemSize;
//        this.quantity = quantity;
//        this.price = price;
//        this.tax = tax;
//        this.couponCode = couponCode;
//        this.discountType = discountType;
//        this.couponAmt = couponAmt;
//        this.itemTotal = itemTotal;
//        this.itemStatus = itemStatus;
//    }
//
//    public Long getItemId() {
//        return id;
//    }
//
//    public void setItemId(Long id) {
//        this.id = id;
//    }
//
//    public String getItemSize() {
//        return itemSize;
//    }
//
//    public void setItemSize(String itemSize) {
//        this.itemSize = itemSize;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public String getTax() {
//        return tax;
//    }
//
//    public void setTax(String tax) {
//        this.tax = tax;
//    }
//
//    public String getCouponCode() {
//        return couponCode;
//    }
//
//    public void setCouponCode(String couponCode) {
//        this.couponCode = couponCode;
//    }
//
//    public String getDiscountType() {
//        return discountType;
//    }
//
//    public void setDiscountType(String discountType) {
//        this.discountType = discountType;
//    }
//
//    public String getCouponAmt() {
//        return couponAmt;
//    }
//
//    public void setCouponAmt(String couponAmt) {
//        this.couponAmt = couponAmt;
//    }
//
//    public String getItemTotal() {
//        return itemTotal;
//    }
//
//    public void setItemTotal(String itemTotal) {
//        this.itemTotal = itemTotal;
//    }
//
//    public String getItemStatus() {
//        return itemStatus;
//    }
//
//    public void setItemStatus(String itemStatus) {
//        this.itemStatus = itemStatus;
//    }
//
//    public Set<ItemOrder> getItemOrders() {
//        return itemOrders;
//    }
//
//    public void setItemOrders(Set<ItemOrder> itemOrders) {
//        this.itemOrders = itemOrders;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//}
