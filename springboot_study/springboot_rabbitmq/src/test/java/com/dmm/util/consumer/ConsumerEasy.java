package com.dmm.util.consumer;

import com.dmm.util.ConnectionUtil;
import com.dmm.util.my.MyConsumer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr. Du
 * @explain 简单的生产发送，队列==路由，内部转化
 * @createTime 2019/12/2 20:37
 * @motto The more learn, the more found his ignorance.
 */

public class ConsumerEasy {

    private final static String QUEUE_NAME = "unit_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel=connection.createChannel();

        /**
         * 声明队列
         * 队列名+
         * 是否持久化+是否排外  即只允许该channel访问该队列   一般等于true的话用于一个队列只能有一个消费者来消费的场景+
         * 是否自动删除  消费完删除+
         * 其他属性
         */
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-message-ttl",3000);
        channel.queueDeclare(QUEUE_NAME,false, false, false, arguments);

        /**
         * 定义消费者
         */
        Consumer consumer=new MyConsumer(channel);

//        //开启事务
//        channel.txSelect();
//        //提交事务
//        channel.txCommit();
//        //回滚事务
//        channel.txRollback();

        //自动应答
        channel.basicConsume(QUEUE_NAME, true, consumer);

        //该方法会阻塞,不关闭的话
        //channel.close();
        //connection.close();
    }
}

