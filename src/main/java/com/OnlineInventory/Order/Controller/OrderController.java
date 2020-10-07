package com.OnlineInventory.Order.Controller;

import com.OnlineInventory.Order.Commons.ApiResponse;
import com.OnlineInventory.Order.DTO.OrderDTO;
import com.OnlineInventory.Order.Model.Order;
import com.OnlineInventory.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")

public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public ApiResponse createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.postOrder(orderDTO);
    }
    
    @GetMapping("/{id}")
    public ApiResponse<Order> getOrderByID(@PathVariable("id") Long id){    	
    	return orderService.getOrderById(id); 
    }

}
