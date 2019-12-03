package com.dmm.utils;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The default exchange is implicitly bound to every queue, with a routing key equal to the queue name.
 * It it not possible to explicitly bind to, or unbind from the default exchange. It also cannot be deleted.
 * 默认交换器隐式地绑定到每个队列，路由键等于队列名称。无法显式绑定到默认交换器或从默认交换器取消绑定。它也不能被删除
 * RabbitMQ默认提供了一个Exchange，名字是空字符串，类型是Direct，绑定到所有的Queue
 * （每一个Queue和这个无名Exchange之间的Binding Key是Queue的名字）==路由的key
 */
@Component
public class PaySend {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;


    public void paysend1(){
        rabbitmqTemplate.convertAndSend("pay","dmm");
    }
}
