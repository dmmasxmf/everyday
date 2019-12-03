package com.dmm.util.producer;

import com.dmm.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr. Du
 * @explain work模式
 * @createTime 2019/12/3 10:26
 * @motto The more learn, the more found his ignorance.
 */

public class ProducerWork {

    private final static String QUEUE_NAME = "unit_work_queue";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //创建连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel=connection.createChannel();
        //声明队列
        /**
         * 队列名+
         * 是否持久化+是否排外  即只允许该channel访问该队列   一般等于true的话用于一个队列只能有一个消费者来消费的场景+
         * 是否自动删除  消费完删除+
         * 其他属性
         */
        channel.queueDeclare(QUEUE_NAME,false, false, false, null);


        /**
         * 交换机
         * 队列名
         * 其他属性  路由
         * 消息body
         */

        for(int i=0;i<10;i++){
            String s="杜明明万岁"+i;
            channel.basicPublish("",QUEUE_NAME,null,s.getBytes());
            Thread.sleep(i*100);
        }

        channel.close();
        connection.close();

    }
}

