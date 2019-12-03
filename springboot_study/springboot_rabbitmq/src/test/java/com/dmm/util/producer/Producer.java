package com.dmm.util.producer;

import com.dmm.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/3 19:35
 * @motto The more learn, the more found his ignorance.
 */

public class Producer {

    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = "missing_routing_key";
    private static final String BINDING_KEY = "bingkey_demo";
    private static final String QUEUE_NAME = "queue_demo";

    public static void main(String[] args) throws Exception{

        //创建连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel=connection.createChannel();

        // 创建一个 type="direct"持久化、非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);

        // 创建一个 持久化、非排他的、非自动删除的交换器
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 将交换器与队列通过路由键绑定 使用 bindingKey
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, BINDING_KEY);

        // 发送一条持久化消息
        String message =  " 这是一条可以被路由的消息";
        String message_no_route = "我是不能被路由的消息";

        try {
            // 使用正确的 routingKey
            channel.basicPublish(EXCHANGE_NAME, BINDING_KEY, true, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());

            //使用错误的  routingKey
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, true, MessageProperties.PERSISTENT_TEXT_PLAIN, message_no_route.getBytes());

            System.err.println("消息发送完成......");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 处理生产者没有正确路由到消息队列的消息
         * 这个可能不会生效：受到 rabbitmq 配置的内存和磁盘的限制 {@link http://www.rabbitmq.com/alarms.html}
         */
        channel.addReturnListener(new ReturnListener() {
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("replyCode:" + replyCode);
                System.out.println("replyText:" + replyText);
                System.out.println("exchange:" + exchange);
                System.out.println("routingKey:" + routingKey);
                System.out.println("properties:" + properties);
                System.out.println("被退回的消息:" + new String(body));
            }
        });

    }
}

