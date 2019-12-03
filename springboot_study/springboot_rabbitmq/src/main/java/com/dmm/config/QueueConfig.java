package com.dmm.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr. Du
 * @explain 队列的定义
 * @createTime 2019/12/1 18:31
 * @motto The more learn, the more found his ignorance.
 */
@Configuration
public class QueueConfig {

    @Bean(name = "1")
    public Queue queue1(){
        return new Queue("1");
    }
    @Bean(name = "2")
    public Queue queue2(){
        return new Queue("2");
    }
    @Bean(name = "3")
    public Queue queue3(){
        return new Queue("3");
    }
    @Bean(name = "4")
    public Queue queue4(){
        return new Queue("4");
    }
    @Bean(name = "5")
    public Queue queue5(){
        return new Queue("5");
    }

}

