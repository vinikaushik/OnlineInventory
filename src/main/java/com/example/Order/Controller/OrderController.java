package com.example.Order.Controller;

import com.example.Order.Commons.ApiResponse;
import com.example.Order.DTO.OrderDTO;
import com.example.Order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")

public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createOrder")
    public ApiResponse createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.postOrder(orderDTO);
    }
//    @RequestBody OrderDto order

}
