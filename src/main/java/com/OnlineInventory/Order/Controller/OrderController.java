package com.inventory.order.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.order.dto.CustomerAddressDTO;
import com.inventory.order.dto.OrderDTO;
import com.inventory.order.dto.OrderReturnItemsDTO;
import com.inventory.order.model.Order;
import com.inventory.order.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.postOrder(orderDTO);
    }
    
    @GetMapping("/orderDetail/{id}")
    public ResponseEntity<Order> getOrderByID(@PathVariable("id") Long id){    	
    	return orderService.getOrderById(id); 
    }


    @GetMapping("/getOrderList/{createdBy}")
    public ResponseEntity<Object> getOrderList(@PathVariable("createdBy") int createdBy){
        return orderService.getOrderListID(createdBy);
    }



    @GetMapping("/getOrderListForAdmin")
    public ResponseEntity<Object> getOrderListForAdmin(@RequestParam Map param){
        //System.out.println("param = createdBy " + param.get("createdBy"));
        System.out.println("param = startDate " + param.get("startDate"));
        System.out.println("param = endDate " + param.get("endDate"));

        Date startDate, toDate = null;
        try{
            startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse((String)param.get("startDate"));
            toDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse((String)param.get("endDate"));
        }catch(Exception e) {
            startDate = new Date();
            toDate = new Date();
        }
        if(param.containsKey("createdBy")) {
            return orderService.getOrderList(Integer.parseInt((String)param.get("createdBy")),startDate, toDate);
        }else {
            return orderService.getOrderListForAdmin(startDate, toDate);
        }
    }


    @PostMapping("/saveAddress")
    public ResponseEntity<Object> saveAddress(@RequestBody CustomerAddressDTO custAddDTO){
        System.out.println("inside save address..");
        return orderService.postCustomerAddress(custAddDTO);
    }

    @GetMapping("/getCustAddress/{createdBy}")
    public ResponseEntity<Object> retrieveUser(@PathVariable int createdBy){
        return orderService.getCustomerAddress(createdBy);
    }
    
    @PutMapping("/cancelOrder/{orderId}")
    public ResponseEntity<Object> cancelOrder(@PathVariable Long orderId){
       // Order order = (Order)orderService.getOrderById(orderId); 
    	
    	return orderService.cancelOrderById(orderId);
    }
    
    @PutMapping("/returnOrder")
    public ResponseEntity<Object> returnOrder(@RequestBody OrderReturnItemsDTO returnItemDTO){
        System.out.println("inside return orders..");
        return orderService.returnOrder(returnItemDTO);
    }
}
