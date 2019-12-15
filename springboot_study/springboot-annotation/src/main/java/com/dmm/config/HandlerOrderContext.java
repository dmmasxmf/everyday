package com.dmm.config;

import com.dmm.strategys.OrderStrategy;
import com.dmm.test.ShortMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/12 20:06
 * @motto The more learn, the more found his ignorance.
 */
@Component
public class HandlerOrderContext {

    @Autowired
    private ApplicationContext applicationContext;
    //存放所有策略类Bean的map
    public static Map<Integer, Class<OrderStrategy>> orderStrategyBeanMap= new HashMap<>();

    public OrderStrategy getOrderStrategy(Integer type){
        Class<OrderStrategy> strategyClass = orderStrategyBeanMap.get(type);
        if(strategyClass==null) throw new IllegalArgumentException("没有对应的订单类型");
        //从容器中获取对应的策略Bean
        return applicationContext.getBean(strategyClass);
    }

    public static Map<String, Class<ShortMessageService>> shortMessageBeanMap= new HashMap<>();

    public ShortMessageService getShortMessageService(String type){
        Class<ShortMessageService> shortMessageServiceClass = shortMessageBeanMap.get(type);
        if(shortMessageServiceClass==null) throw new IllegalArgumentException("没有对应的消息平台");
        //从容器中获取对应的策略Bean
        return applicationContext.getBean(shortMessageServiceClass);
    }
}

