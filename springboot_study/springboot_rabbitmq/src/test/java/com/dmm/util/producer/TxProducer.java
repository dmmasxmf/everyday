package com.dmm.util.producer;

import com.dmm.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr. Du
 * @explain 事务的测试
 * @createTime 2019/12/3 18:11
 * @motto The more learn, the more found his ignorance.
 */

public class TxProducer {

    private final static String QUEUE_NAME = "unit_tx_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel=connection.createChannel();
        //声明队列

        channel.queueDeclare(QUEUE_NAME,false, false, false, null);

        String s="杜明明万岁";

        try {
            //开启事务
            channel.txSelect();
            channel.basicPublish("",QUEUE_NAME,null,s.getBytes());
            System.out.println(1/0);
            //提交事务
            channel.txCommit();

        } catch (IOException e) {
            //回滚事务
            channel.txRollback();
            e.printStackTrace();
        }

        channel.close();
        connection.close();

    }

}

