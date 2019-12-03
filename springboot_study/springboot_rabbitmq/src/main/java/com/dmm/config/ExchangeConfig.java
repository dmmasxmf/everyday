package com.dmm.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr. Du
 * @explain 交换机定义
 * @createTime 2019/12/1 19:05
 * @motto The more learn, the more found his ignorance.
 */
@Configuration
public class ExchangeConfig {

    @Bean
    public Exchange exchange1(){
        return new DirectExchange("1");
    }
    @Bean
    public Exchange exchange2(){
        return new DirectExchange("2");
    }
    @Bean
    public Exchange exchange3(){
        return new DirectExchange("3");
    }
    @Bean
    public Exchange exchange4(){
        return new DirectExchange("4");
    }
    @Bean
    public Exchange exchange5(){
        return new DirectExchange("5");
    }

}

