package com.dmm.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsumerMq {

    public static int i=0;

    @RabbitListener(queues = "hello")
    public void process(Message message, Channel channel) throws IOException {
        
        System.out.println("------------------------------------"+message);

        //System.out.println(1/0);
        if(new String(message.getBody()).equals("error")){
            /**
             *  消息的标记+多次确认吗+是否重新入队
             *  最后一个参数 requeue 设置为true 会把消费失败的消息从新添加到队列的尾端，设置为false不会重新回到队列
             */
            if(i==3){
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
                System.out.println("还是没有成功，记录一个");
            }

            System.out.println("--------------");
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);

            i++;
            System.out.println(i+"vgfybhnumji;.'/");
        }else{
            /**
             * 消息的标记+多条次确认吗
             */
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }

        System.out.println(new String(message.getBody())+"===============");
    }

//    @RabbitHandler
//    public void s(int s){
//        System.out.println(s);
//    }

}
