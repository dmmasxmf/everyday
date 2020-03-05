package com.dmm.xxljob.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/1/15 14:44
 * @motto The more learn, the more found his ignorance.
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public void test(){
        System.out.println("----------");
    }
}

