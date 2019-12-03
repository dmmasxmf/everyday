package com.dmm.util.producer;

import com.dmm.util.ConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr. Du
 * @explain fanout交换机
 * @createTime 2019/12/2 16:29
 * @motto The more learn, the more found his ignorance.
 */

public class ProducerHeaders {

    /**
     * 路由key
     */
    private final static String ROUTE_KEY = "unit_route_key";
    /**
     * 交换机
     * fanout:把所有发送到该Exchange的消息投递到所有与它绑定的队列中。
     *
     * direct:把消息投递到那些binding key与routing key完全匹配的队列中。
     *
     * topic:将消息路由到binding key与routing key模式匹配的队列中。
     *
     * Headers:不依赖于Routing Key与Binding Key的匹配规则来转发消息，交换器的路由规则是通过消息头的Headers属性来进行匹配转发的
     */
    private final static String EXCHANGE_NAME="unit_headers_exchange";

    private final static String EXCHANGE_tYPE="headers";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        Connection connection=ConnectionUtil.getConnection();
        //创建通道
        Channel channel=connection.createChannel();
        Map<String, Object> headers = new Hashtable<String, Object>();
        /**
         * 键值对的Hash结构中要求携带一个键“x-match”，这个键的Value可以是any或all，
         * 代表消息携带的Hash是需要全部匹配(all)，还是仅匹配一个键(any)。
         */
        headers.put("x-match","any");
        headers.put("dmm","ljh");

        AMQP.BasicProperties basicProperties=new AMQP.BasicProperties();
        //
        basicProperties.builder().headers(headers).build();
        //交换机声明
        /**
         * 交换机名称+
         * 交换机类型
         */
        //channel.exchangeDeclare(EXCHANGE_NAME,EXCHANGE_tYPE,false,false,headers);
        channel.exchangeDeclare(EXCHANGE_NAME,EXCHANGE_tYPE);


        String s="杜明明万岁";
        /**
         * 声明路由规则
         * 交换机
         * 队列名 绑定规则在我这里由消费者定义
         * 其他属性  路由
         * 消息body
        */
        channel.basicPublish(EXCHANGE_NAME,ROUTE_KEY,basicProperties,s.getBytes());


        channel.close();
        connection.close();

    }

}

