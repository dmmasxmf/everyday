package com.dmm.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/1 19:32
 * @motto The more learn, the more found his ignorance.
 */
@Component
@RabbitListener
public class RabbitMqListenerTest {

    @RabbitListener(queues = "1")
    public void queueListener1(String message){
        System.out.println(message+"__________=====================1");
    }

    @RabbitListener(queues = "2")
    public void queueListener2(String message){
        System.out.println(message+"__________=====================2");
    }

}

