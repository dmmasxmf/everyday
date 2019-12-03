package com.dmm.util;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr. Du
 * @explain 定义连接工厂
 * @createTime 2019/12/2 11:03
 * @motto The more learn, the more found his ignorance.
 */

public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory=new ConnectionFactory();
        //host port user pass vhost(虚拟主机)
        connectionFactory.setHost("47.111.2.18");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("test");
        connectionFactory.setPassword("test");
        connectionFactory.setVirtualHost("/test");


        return connectionFactory.newConnection();

    }

}

