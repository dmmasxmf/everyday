package com.dmm.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/1 19:24
 * @motto The more learn, the more found his ignorance.
 */
@Configuration
public class BindingConfig {

    @Autowired
    private ExchangeConfig exchangeConfig;

    @Autowired
    private RoutingConfig routingConfig;

    @Autowired
    private QueueConfig queueConfig;

    /**
     *  队列+交换机+路由规则
     * @return
     */
    @Bean
    public Binding binding111(){
        return BindingBuilder.bind(queueConfig.queue1()).
                to(exchangeConfig.exchange1()).
                with(routingConfig.getRouting1()).
                noargs();
    }

    @Bean
    public Binding binding112(){
        return BindingBuilder.bind(queueConfig.queue1()).
                to(exchangeConfig.exchange1()).
                with(routingConfig.getRouting2()).
                noargs();
    }

    /**
     * 队列+交换机+路由规则
     * @return
     */
    @Bean
    public Binding binding211(){
        return BindingBuilder.bind(queueConfig.queue2()).
                to(exchangeConfig.exchange1()).
                with(routingConfig.getRouting1()).
                noargs();
    }



}

