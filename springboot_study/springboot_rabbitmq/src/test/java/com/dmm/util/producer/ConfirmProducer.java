package com.dmm.util.producer;

import com.dmm.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr. Du
 * @explain confirm 针对于生产者到服务器的内容是否同步过去
 * @createTime 2019/12/3 18:45
 * @motto The more learn, the more found his ignorance.
 */

public class ConfirmProducer {

    private final static String QUEUE_NAME = "unit_confirm_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //创建连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel=connection.createChannel();
        //声明队列

        channel.queueDeclare(QUEUE_NAME,false, false, false, null);

        channel.confirmSelect();

        String s="杜明明万岁";

        for(int i=0;i<10;i++){
            try {
                if(i==5){
                    System.out.println(1/0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        channel.basicPublish("",QUEUE_NAME,null,s.getBytes());
        if(!channel.waitForConfirms()){
            System.out.println("失败");
        }else{
            System.out.println("成功");
        }
        channel.close();
        connection.close();

    }
}

