package com.dmm.simple.product;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/4 16:57
 * @motto The more learn, the more found his ignorance.
 */
@Component
public class SimpleProduct {

    @Autowired
    RabbitTemplate amqpTemplate;

    public String simpleSend(String s){

        amqpTemplate.convertSendAndReceive("1",s);

        return "成功";
    }
    public String simpleSend2(String s){

        amqpTemplate.convertSendAndReceive("2",s);

        return "成功";
    }

}

