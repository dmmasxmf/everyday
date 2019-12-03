package com.dmm.util.producer;

import com.dmm.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr. Du
 * @explain confirm 针对于生产者到服务器的内容是否同步过去 异步
 * @createTime 2019/12/3 18:45
 * @motto The more learn, the more found his ignorance.
 */

public class ConfirmProducerAsyn {

    private final static String QUEUE_NAME = "unit_confirm_queue2";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //创建连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel=connection.createChannel();
        //声明队列
        Map<String, Object> arguments = new Hashtable<String, Object>();
        arguments.put("x-max-length",10);
        channel.queueDeclare(QUEUE_NAME,false, false, false, arguments);
        //开启confirm模式
        channel.confirmSelect();

        //未确认的消息放入
        SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
        //添加监听通道
        channel.addConfirmListener(new ConfirmListener() {
            //没有问题的handleAck 成功
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                //deliveryTag；唯一消息标签
                //multiple：是否批量
                System.out.println(confirmSet.size()+"氟利昂+++++++++++++++++++++++++");
                if(multiple){   //多个的
                    System.out.println("handleAck:multiple");
                    confirmSet.headSet(deliveryTag+1).clear();
                }else{          //单个的
                    System.out.println("handleAck:multiple false");
                    confirmSet.remove(deliveryTag);
                }
            }
            //有问题的反馈Nack 失败
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                if(multiple){
                    System.out.println("handleNack:multiple");
                    confirmSet.headSet(deliveryTag+1).clear();
                }else{
                    System.out.println("handleNack:multiple false");
                    confirmSet.remove(deliveryTag);
                }
            }
        });

        //channel.addReturnListener();

        String msg = "hello Confirm11111111";


        while(true){
            //获取信道的号，发送成功后，在未确认的号添加
            long seqNo = channel.getNextPublishSeqNo();
            if(seqNo==8){
                channel.basicPublish("","大傻逼v地方",null,msg.getBytes());
            }else{
                channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            }

            confirmSet.add(seqNo);

            Thread.sleep(1000);
        }

    }
}

