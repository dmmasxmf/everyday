package com.dmm.config;

import com.dmm.annotation.HandlerOrderType;
import com.dmm.strategys.OrderStrategy;
import com.dmm.test.ShortMessageAnnotation;
import com.dmm.test.ShortMessageService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/12 20:07
 * @motto The more learn, the more found his ignorance.
 */
@Component
public class HandlerOrderProcessor implements ApplicationContextAware {

    /**
     * 获取所有的策略Beanclass 加入HandlerOrderContext属性中
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //获取所有策略注解的Bean
        Map<String, Object> orderStrategyMap = applicationContext.getBeansWithAnnotation(HandlerOrderType.class);

        orderStrategyMap.forEach((k,v)->{
            Class<OrderStrategy> orderStrategyClass = (Class<OrderStrategy>) v.getClass();
            int type = orderStrategyClass.getAnnotation(HandlerOrderType.class).value();
            //将class加入map中,type作为key
            HandlerOrderContext.orderStrategyBeanMap.put(type,orderStrategyClass);
        });

        //获取所有策略注解的Bean 消息的集合
        Map<String, Object> shortMessageMap = applicationContext.getBeansWithAnnotation(ShortMessageAnnotation.class);

        shortMessageMap.forEach((k,v)->{
            Class<ShortMessageService> shortMessageServiceClass = (Class<ShortMessageService>) v.getClass();
            String type = shortMessageServiceClass.getAnnotation(ShortMessageAnnotation.class).value();
            //将class加入map中,type作为key
            HandlerOrderContext.shortMessageBeanMap.put(type,shortMessageServiceClass);
        });

    }
}

