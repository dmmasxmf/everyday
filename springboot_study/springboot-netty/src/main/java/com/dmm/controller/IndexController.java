package com.dmm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/30 9:40
 * @motto The more learn, the more found his ignorance.
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mav=new ModelAndView("socket");
        //new Random(1000) RandomUtil.randomNumbers(6)
        mav.addObject("uid",new Random(1000).nextInt(10000));
        return mav;
    }

}

