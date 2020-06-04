package com.dmm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mr. Du
 * @explain 自定义参数获取
 * @createTime 2020/6/1 14:49
 * @motto The more learn, the more found his ignorance.
 */
@Component
public class LoadArguments {

    @Autowired
    public LoadArguments(ApplicationArguments applicationArguments){

        boolean skip = applicationArguments.containsOption("skip");

        System.out.println("skip = " + skip);

        List<String> nonOptionArgs = applicationArguments.getNonOptionArgs();

        for (String nonOptionArg : nonOptionArgs) {
            System.out.println("nonOptionArg = " + nonOptionArg);
        }

        System.out.println("applicationArguments = " + applicationArguments);

    }
}

