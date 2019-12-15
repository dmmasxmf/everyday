package com.dmm.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/14 20:29
 * @motto The more learn, the more found his ignorance.
 */
@Controller
@RequestMapping("discovery")
public class DiscoveryController {

    @NacosInjected
    private NamingService namingService;

    @RequestMapping(value = "/get")
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    @ResponseBody
    public String echo(@PathVariable String string) {

        System.out.println("----------------------------------------------");
        return "Hello Nacos Discovery " + string;
    }

//    @RequestMapping(value = "/echo/{aa}/{bb}", method = RequestMethod.GET)
//    public String echo(@PathVariable("aa") String aa,@PathVariable("bb") String bb) {
//
//        System.out.println("----------------------------------------------");
//        return "Hello Nacos Discovery " + aa;
//    }

}

