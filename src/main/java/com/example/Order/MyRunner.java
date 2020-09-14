package com.example.Order;

import com.example.Order.Model.CustomerDetail;
import com.example.Order.Model.OrderItem;
import com.example.Order.Repository.CustomerDetailRepository;
import com.example.Order.Repository.ItemRepository;
import com.example.Order.Repository.OrderRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CustomerDetailRepository customerDetailRepository;

    @Override
    public void run(String... args) throws Exception {
        itemRepository.save(new OrderItem("ABC",1,"abc",1l,"abc","desc",3,2.0,"abc","2.",2, new Timestamp(System.currentTimeMillis()),null,null ));
        customerDetailRepository.save(new CustomerDetail("test","","test","9898989898","test@test.com","idk","idk","idk","idk","idk","idk"));
    }
}
