package com.OnlineInventory.Order.Commons;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ASAD QURESHI on 1/23/2020.
 */
public class ApiResponse<T> {

    private String Status;
    Timestamp timestamp;
    Long orderId;
    String message;
    String details;
    public ApiResponse( Long orderId, String Status,  Timestamp timestamp) {

        this.orderId= orderId;
        this.Status = Status;
        this.timestamp = timestamp;


    }

    public ApiResponse( String message) {

        this.Status = message;
    }

    public ApiResponse( Timestamp timestamp,String message, String details ) {

       this.timestamp= timestamp;
       this.message = message;
       this.details= details;


    }

//    public ApiResponse(int status, String message, Object result) {
//        this.status = status;
//        this.message = message;
//        this.result = result;
//    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
