package com.dmm.utils;

import com.dmm.config.RabbitmqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息的生產方
 */
@Component
public class RabbitmqUtils {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDmm(long id){
        amqpTemplate.convertAndSend("dmm",id);
    }

    public void sendMmd(long id){
        amqpTemplate.convertAndSend("mmd",id);
    }

    // 規則 交換機 規則  a a
    public void sendAA(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_A,RabbitmqConfig.ROUTINGKEY_A,id);
    }

    public void sendAB(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_A,RabbitmqConfig.ROUTINGKEY_B,id);
    }
    public void sendAC(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_A,RabbitmqConfig.ROUTINGKEY_C,id);
    }
    public void sendBA(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_B,RabbitmqConfig.ROUTINGKEY_A,id);
    }
    public void sendBB(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_B,RabbitmqConfig.ROUTINGKEY_B,id);
    }
    public void sendBC(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_B,RabbitmqConfig.ROUTINGKEY_C,id);
    }
    public void sendCA(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_C,RabbitmqConfig.ROUTINGKEY_A,id);
    }
    public void sendCB(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_C,RabbitmqConfig.ROUTINGKEY_B,id);
    }
    public void sendCC(long id){
        // 參數是 交換機 驗證參數  入參
        amqpTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_C,RabbitmqConfig.ROUTINGKEY_C,id);
    }



}
