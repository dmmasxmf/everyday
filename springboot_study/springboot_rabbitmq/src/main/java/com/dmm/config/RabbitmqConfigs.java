package com.dmm.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 生产者确认机制
 */
@Configuration
public class RabbitmqConfigs{

    Logger logger= LoggerFactory.getLogger(RabbitmqConfigs.class);

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {

        //ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调   即消息发送到exchange  ack
        //ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调  即消息发送不到任何一个队列中  ack

        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey)
                -> {
            String correlationId=message.getMessageProperties().getCorrelationId();
            System.out.println("消息"+correlationId+"应答码"+replyCode+"原有"+replyText+"交换机"+exchange+"路由"+routingKey);
            logger.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
        });
        rabbitTemplate.setConfirmCallback((correlationData,ack,cause)->{
            if(ack){
                System.out.println("成功");
            }
            else {
                System.out.println("失败");
            }
        });
        return rabbitTemplate;
    }

//    @Override
//    public void confirm(CorrelationData correlationData, boolean b, String s) {
//
//    }
}
