package com.dmm.controller;

import com.dmm.bean.Order;
import com.dmm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/12 20:15
 * @motto The more learn, the more found his ignorance.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/handler/{type}")
    public void handleOrder(@PathVariable Integer type){
        Order order = Order.build()
                .add("name", "微信订单")
                .add("price", 99.9)
                .add("type", type);
        orderService.handleOrder(order);
    }
}

