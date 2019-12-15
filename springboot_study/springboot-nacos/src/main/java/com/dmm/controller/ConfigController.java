package com.dmm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mr. Du
 * @explain 配置文件的发现
 * @createTime 2019/12/14 20:11
 * @motto The more learn, the more found his ignorance.
 */
@Controller
@RequestMapping("config")
@RefreshScope
public class ConfigController {

    //springboot
    //@NacosValue(value = "${useLocalCache:false}")

    //spirngcloud
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @RequestMapping(value = "/get")
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }

}

