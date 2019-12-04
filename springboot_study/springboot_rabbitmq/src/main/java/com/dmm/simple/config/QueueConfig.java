package com.dmm.simple.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/4 16:50
 * @motto The more learn, the more found his ignorance.
 */
@Configuration
public class QueueConfig {

    @Bean(name = "1")
    public Queue queue1(){
        /**
         * 默认队列，持久化
         */
        return new Queue("1");
    }
    @Bean(name = "2")
    public Queue queue2(){
        /**
         * 不持久化
         */
        return new Queue("2",false);
    }
}

