package com.dmm.service.impl;

import com.dmm.bean.Order;
import com.dmm.config.HandlerOrderContext;
import com.dmm.service.OrderService;
import com.dmm.strategys.OrderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/12 20:10
 * @motto The more learn, the more found his ignorance.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    HandlerOrderContext handlerOrderContext;


    @Override
    public void handleOrder(Order order) {
        OrderStrategy orderStrategy=handlerOrderContext.getOrderStrategy(order.getType());
        orderStrategy.handleOrder(order);
    }
}

