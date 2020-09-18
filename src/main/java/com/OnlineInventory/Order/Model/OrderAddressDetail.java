package com.OnlineInventory.Order.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class OrderAddressDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id" ,nullable=false)
    Order order;

    private  String shipToFirstName;
    private String shipToMiddleName;
    private String shipToLastName;
    private  String shipToAddLine1;
    private  String shipToAddLine2;
    private  String shipToCity;
    private  String shipToZipCode;
    private  String shipToState;
    private  String shipToCountry;
    private  Boolean shipBillToSameAddress;
    private  String billToFirstName;
    private  String billToMiddleName;
    private  String billToLastName;
    private  String billToAddLine1;
    private  String billToAddLine2;
    private  String billToCity;
    private  String billToZipCode;
    private  String billToState;
    private  String billToCountry;
    private  Integer createdBy;
    private Timestamp createdDate;
    private Integer updatedBy;
    private Timestamp lastUpdated;

    public OrderAddressDetail() {

    }

    public OrderAddressDetail(Long id, Order order, String shipToFirstName, String shipToMiddleName, String shipToLastName, String shipToAddLine1, String shipToAddLine2, String shipToCity, String shipToZipCode, String shipToState, String shipToCountry, Boolean shipBillToSameAddress, String billToFirstName, String billToMiddleName, String billToLastName, String billToAddLine1, String billToAddLine2, String billToCity, String billToZipCode, String billToState, String billToCountry, Integer createdBy, Timestamp createdDate, Integer updatedBy, Timestamp lastUpdated) {
        this.id = id;
        this.order = order;
        this.shipToFirstName = shipToFirstName;
        this.shipToMiddleName = shipToMiddleName;
        this.shipToLastName = shipToLastName;
        this.shipToAddLine1 = shipToAddLine1;
        this.shipToAddLine2 = shipToAddLine2;
        this.shipToCity = shipToCity;
        this.shipToZipCode = shipToZipCode;
        this.shipToState = shipToState;
        this.shipToCountry = shipToCountry;
        this.shipBillToSameAddress = shipBillToSameAddress;
        this.billToFirstName = billToFirstName;
        this.billToMiddleName = billToMiddleName;
        this.billToLastName = billToLastName;
        this.billToAddLine1 = billToAddLine1;
        this.billToAddLine2 = billToAddLine2;
        this.billToCity = billToCity;
        this.billToZipCode = billToZipCode;
        this.billToState = billToState;
        this.billToCountry = billToCountry;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.lastUpdated = lastUpdated;
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

    public String getShipToFirstName() {
        return shipToFirstName;
    }

    public void setShipToFirstName(String shipToFirstName) {
        this.shipToFirstName = shipToFirstName;
    }

    public String getShipToMiddleName() {
        return shipToMiddleName;
    }

    public void setShipToMiddleName(String shipToMiddleName) {
        this.shipToMiddleName = shipToMiddleName;
    }

    public String getShipToLastName() {
        return shipToLastName;
    }

    public void setShipToLastName(String shipToLastName) {
        this.shipToLastName = shipToLastName;
    }

    public String getShipToAddLine1() {
        return shipToAddLine1;
    }

    public void setShipToAddLine1(String shipToAddLine1) {
        this.shipToAddLine1 = shipToAddLine1;
    }

    public String getShipToAddLine2() {
        return shipToAddLine2;
    }

    public void setShipToAddLine2(String shipToAddLine2) {
        this.shipToAddLine2 = shipToAddLine2;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public void setShipToCity(String shipToCity) {
        this.shipToCity = shipToCity;
    }

    public String getShipToZipCode() {
        return shipToZipCode;
    }

    public void setShipToZipCode(String shipToZipCode) {
        this.shipToZipCode = shipToZipCode;
    }

    public String getShipToState() {
        return shipToState;
    }

    public void setShipToState(String shipToState) {
        this.shipToState = shipToState;
    }

    public String getShipToCountry() {
        return shipToCountry;
    }

    public void setShipToCountry(String shipToCountry) {
        this.shipToCountry = shipToCountry;
    }

    public Boolean getShipBillToSameAddress() {
        return shipBillToSameAddress;
    }

    public void setShipBillToSameAddress(Boolean shipBillToSameAddress) {
        this.shipBillToSameAddress = shipBillToSameAddress;
    }

    public String getBillToFirstName() {
        return billToFirstName;
    }

    public void setBillToFirstName(String billToFirstName) {
        this.billToFirstName = billToFirstName;
    }

    public String getBillToMiddleName() {
        return billToMiddleName;
    }

    public void setBillToMiddleName(String billToMiddleName) {
        this.billToMiddleName = billToMiddleName;
    }

    public String getBillToLastName() {
        return billToLastName;
    }

    public void setBillToLastName(String billToLastName) {
        this.billToLastName = billToLastName;
    }

    public String getBillToAddLine1() {
        return billToAddLine1;
    }

    public void setBillToAddLine1(String billToAddLine1) {
        this.billToAddLine1 = billToAddLine1;
    }

    public String getBillToAddLine2() {
        return billToAddLine2;
    }

    public void setBillToAddLine2(String billToAddLine2) {
        this.billToAddLine2 = billToAddLine2;
    }

    public String getBillToCity() {
        return billToCity;
    }

    public void setBillToCity(String billToCity) {
        this.billToCity = billToCity;
    }

    public String getBillToZipCode() {
        return billToZipCode;
    }

    public void setBillToZipCode(String billToZipCode) {
        this.billToZipCode = billToZipCode;
    }

    public String getBillToState() {
        return billToState;
    }

    public void setBillToState(String billToState) {
        this.billToState = billToState;
    }

    public String getBillToCountry() {
        return billToCountry;
    }

    public void setBillToCountry(String billToCountry) {
        this.billToCountry = billToCountry;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
