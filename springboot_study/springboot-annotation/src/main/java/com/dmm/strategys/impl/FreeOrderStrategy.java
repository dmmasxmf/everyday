package com.dmm.strategys.impl;

import com.dmm.annotation.HandlerOrderType;
import com.dmm.bean.Order;
import com.dmm.strategys.OrderStrategy;
import org.springframework.stereotype.Component;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/12 19:59
 * @motto The more learn, the more found his ignorance.
 */
@Component
@HandlerOrderType(Order.FREE)
public class FreeOrderStrategy implements OrderStrategy {
    @Override
    public void handleOrder(Order order) {
        System.out.println("----处理免费订单----");
    }
}

