package com.dmm.controller;

import com.dmm.ShortMessageWeightVo;
import com.dmm.WeightTest;
import com.dmm.bean.Order;
import com.dmm.config.HandlerOrderContext;
import com.dmm.service.OrderService;
import com.dmm.test.ShortMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/12 20:15
 * @motto The more learn, the more found his ignorance.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    HandlerOrderContext handlerOrderContext;


    @GetMapping("/handler/{type}")
    public void handleOrder(@PathVariable Integer type){
        Order order = Order.build()
                .add("name", "微信订单")
                .add("price", 99.9)
                .add("type", type);
        orderService.handleOrder(order);
    }

    @GetMapping("/String/{type}")
    public void handleShortMessage(@PathVariable String type){
        ShortMessageService shortMessageService=handlerOrderContext.getShortMessageService(type);
        shortMessageService.getShortMessageBalance();
        shortMessageService.sendShortMessage();
    }

    @GetMapping("/string")
    public void handleShortMessage2(){

        List<ShortMessageWeightVo> shortMessageWeightVoList=new ArrayList<>(7);
        ShortMessageWeightVo shortMessageWeightVo=new ShortMessageWeightVo();
        shortMessageWeightVo.setRequestUrl("lexin");
        shortMessageWeightVo.setWeight(1);
        ShortMessageWeightVo shortMessageWeightVo2=new ShortMessageWeightVo();
        shortMessageWeightVo2.setRequestUrl("yunxin");
        shortMessageWeightVo2.setWeight(2);

        shortMessageWeightVoList.add(shortMessageWeightVo);
        shortMessageWeightVoList.add(shortMessageWeightVo2);



        WeightTest weightTest=new WeightTest();

        ShortMessageWeightVo shortMessageWeightVo3=weightTest.randomKey(shortMessageWeightVoList,new Random());


        ShortMessageService shortMessageService=handlerOrderContext.getShortMessageService(shortMessageWeightVo3.getRequestUrl());
        shortMessageService.getShortMessageBalance();
        shortMessageService.sendShortMessage();
    }


}

