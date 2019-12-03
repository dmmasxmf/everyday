package com.dmm.util.my;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @author Mr. Du
 * @explain 自定义消费者
 * @createTime 2019/12/3 10:04
 * @motto The more learn, the more found his ignorance.
 */

public class MyConsumer extends DefaultConsumer {
    /**
     * Constructs a new instance and records its association to the passed-in channel.
     *
     * @param channel the channel to which this consumer is attached
     */
    public MyConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag,
                               Envelope envelope,
                               AMQP.BasicProperties properties,
                               byte[] body)
            throws IOException
    {
        // no work to do

        System.err.println("-----------consume message----------");
        //消费者标记
        System.err.println("consumerTag: " + consumerTag);
        //消息的包装层
        System.err.println("envelope: " + envelope);
        //额外的属性
        System.err.println("properties: " + properties);
        //内容
        System.err.println("body: " + new String(body));

        /**
         * consumerTag: amq.ctag--pYvqyo5pahEfnW2PTULBQ
         * envelope: Envelope(deliveryTag=2, redeliver=false, exchange=, routingKey=unit_simple_queue)
         * properties: #contentHeader<basic>(content-type=null, content-encoding=null, headers={}, delivery-mode=1, priority=null, correlation-id=null, reply-to=null, expiration=null, message-id=null, timestamp=null, type=null, user-id=null, app-id=null, cluster-id=null)
         * body: 辅导班哪家快递烦恼距北大街v分v
         * route
         */
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //返回确认状态
        getChannel().basicAck(envelope.getDeliveryTag(),false);


    }
}

