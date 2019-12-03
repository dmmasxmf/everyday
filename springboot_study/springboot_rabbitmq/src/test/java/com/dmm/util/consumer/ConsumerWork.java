package com.dmm.util.consumer;

import com.dmm.util.ConnectionUtil;
import com.dmm.util.my.MyConsumer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/2 20:37
 * @motto The more learn, the more found his ignorance.
 */

public class ConsumerWork {

    private final static String QUEUE_NAME = "unit_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel=connection.createChannel();

        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);
        /**
         * 声明队列
         * 队列名+
         * 是否持久化+
         * 是否排外  即只允许该channel访问该队列   一般等于true的话用于一个队列只能有一个消费者来消费的场景+
         * 是否自动删除  消费完删除+
         * 其他属性
         */
        channel.queueDeclare(QUEUE_NAME,false, false, false, null);

        /**
         * 定义消费者
         */
        Consumer consumer=new MyConsumer(channel);

        //关闭自动应答 false 开启自动应答 true
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}

