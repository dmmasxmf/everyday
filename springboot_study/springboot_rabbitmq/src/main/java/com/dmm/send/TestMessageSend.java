package com.dmm.send;

import com.alibaba.fastjson.JSON;
import com.dmm.entry.BusinessProcess;
import com.dmm.entry.VmCommand;
import com.dmm.entry.VmEntry;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/4/20 10:02
 * @motto The more learn, the more found his ignorance.
 */
@Component
@Slf4j
public class TestMessageSend {

    @Autowired
    RabbitTemplate amqpTemplate;

    public void issueOrder(){

        VmCommand vmCommand=new VmCommand();
        vmCommand.setCommand(0);
        vmCommand.setCommandExplain("分配虚机");
        BusinessProcess businessProcess=new BusinessProcess();
        businessProcess.setBusinessId(1);
        businessProcess.setUuid(UUID.randomUUID().toString());
        vmCommand.setBusinessProcess(businessProcess);
        VmEntry vmEntry=new VmEntry();
        vmEntry.setOprMode("soft");
        vmEntry.setUserName("dmm");
        vmEntry.setUserPwd("123.com");
        vmEntry.setVmConfig(1);
        vmEntry.setVmId(UUID.randomUUID().toString());
        vmEntry.setVmType(5);
        vmCommand.setVmEntry(vmEntry);
        //JSON.toJSONString(JSON.toJSON(vmCommand))
        amqpTemplate.convertAndSend("issue-order",JSON.toJSONBytes(JSON.toJSON(vmCommand)));
    }

    @RabbitListener(queues = "return-order")
    public void returnOrder(byte[] bytes){

        System.out.println("------>"+new String(bytes)+"<------");
        //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);

    }
}

