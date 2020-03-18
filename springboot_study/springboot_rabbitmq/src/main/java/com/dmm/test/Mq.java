package com.dmm.test;

import com.alibaba.fastjson.JSON;
import com.aoyou.yunny.common.result.BaseResult;
import com.aoyou.yunny.common.vo.TimeChargeVO;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * main方法获取连接
 * @author DMM
 * @create 2019/8/27
 */

public class Mq {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("47.111.2.18");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        System.out.println(connectionFactory.newConnection());
    }

//    public static void main(String[] args) {
//
//        TimeChargeVO timeChargeVO=new TimeChargeVO();
//        timeChargeVO.setName("dmmmm");
//
//        String orderNo="dvgfcbhjcf1000000000";
//
//        BaseResult baseResult=BaseResult.success(new HashMap<String,Object>(4){{
//            put("timeChargeVO",timeChargeVO);
//            put("orderNo",orderNo);
//        }});
//
//        Map map= JSON.parseObject(JSON.toJSONString(baseResult.getData()),Map.class);
//
//        String orderNo2=map.get("orderNo").toString();
//
//        System.out.println(map.get("timeChargeVO"));
//        //TimeChargeVO timeChargeVO2=JSON.parseObject(JSON.toJSONString(map.get("timeChargeVO")),TimeChargeVO.class);
//
//        System.out.println(orderNo2);
//        System.out.println(JSON.parseObject(map.get("timeChargeVO").toString(),TimeChargeVO.class).getName());
//
//    }


}

