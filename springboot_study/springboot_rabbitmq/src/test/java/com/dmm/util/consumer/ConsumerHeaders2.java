package com.dmm.util.consumer;

import com.dmm.util.ConnectionUtil;
import com.dmm.util.my.MyConsumer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr. Du
 * @explain channel 请求头给消费者 设置headers
 * @createTime 2019/12/2 20:37
 * @motto The more learn, the more found his ignorance.
 */

public class ConsumerHeaders2 {

    private final static String QUEUE_NAME = "unit_headers_queue2";

    private final static String EXCHANGE_NAME="unit_headers_exchange";

    /**
     * 路由key
     */
    private final static String ROUTE_KEY = "unit_route_key";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel=connection.createChannel();

        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);

        Map<String, Object> headers = new Hashtable<String, Object>();
        /**
         * 键值对的Hash结构中要求携带一个键“x-match”，这个键的Value可以是any或all，
         * 代表消息携带的Hash是需要全部匹配(all)，还是仅匹配一个键(any)。
         * Features
         */
        headers.put("x-match","any");
        headers.put("dmm","ljh");
        /**
         * 声明队列
         * 队列名+
         * 是否持久化+是否排外  即只允许该channel访问该队列   一般等于true的话用于一个队列只能有一个消费者来消费的场景+
         * 是否自动删除  消费完删除+
         * 其他属性
         */
        channel.queueDeclare(QUEUE_NAME,false, false, false, headers);

        /**
         * 队列绑定+路由
         * 队列名+交换机+路由key
         */
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTE_KEY);

        /**
         * 定义消费者
         */
        Consumer consumer=new MyConsumer(channel);

        //confirmSelect


        channel.basicConsume(QUEUE_NAME, true, consumer);

        //该方法会阻塞,不关闭的话
        //channel.close();
        //connection.close();
    }
}

