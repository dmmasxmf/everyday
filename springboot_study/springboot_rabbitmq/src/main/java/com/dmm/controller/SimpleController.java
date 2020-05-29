package com.dmm.controller;

import com.dmm.send.TestMessageSend;
import com.dmm.simple.product.SimpleProduct;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/4 17:09
 * @motto The more learn, the more found his ignorance.
 */
@RestController
public class SimpleController {

    @Autowired
    private SimpleProduct simpleProduct;

    @GetMapping("/simple")
    public String simpleSend(String s){
        //
        simpleProduct.simpleSend2(s);
        simpleProduct.simpleSend(s);
        simpleProduct.simpleSend(s);
        return "----";
    }

    @Autowired
    private TestMessageSend testMessageSend;
    @GetMapping("/test")
    public void test(){
        testMessageSend.issueOrder();
    }

    public static void main(String[] args) {
        Map<String,String> stringMap=new HashMap<>(4);

        stringMap.put("100","102");
        stringMap.put("100","123456");

        System.out.println(stringMap.get("100"));

        String s="true";

        if(Boolean.getBoolean(s)){
            System.out.println("byhnju");
        }
    }
}

