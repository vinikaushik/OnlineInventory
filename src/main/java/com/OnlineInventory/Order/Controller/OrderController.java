package com.OnlineInventory.Order.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineInventory.Order.DTO.CustomerAddressDTO;
import com.OnlineInventory.Order.DTO.OrderDTO;
import com.OnlineInventory.Order.Model.Order;
import com.OnlineInventory.Order.Service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/order")

public class OrderController {

    @Autowired
    OrderService orderService;

    /*
     * 
     */
    @PostMapping("/createOrder")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.postOrder(orderDTO);
    }
    
    @GetMapping("/orderDetail/{id}")
    public ResponseEntity<Order> getOrderByID(@PathVariable("id") Long id){
    	System.out.println("inside getOrderDetail"+id);
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
}
