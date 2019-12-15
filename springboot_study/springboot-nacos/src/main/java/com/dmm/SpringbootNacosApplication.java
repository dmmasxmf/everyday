package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/14 20:04
 * @motto The more learn, the more found his ignorance.
 */

// 配置文件的获取
//@SpringBootApplication
//@NacosPropertySource(dataId = "example", autoRefreshed = true)

//服务获取 springboot
//@SpringBootApplication

@SpringBootApplication
//开启服务注册发现功能
@EnableDiscoveryClient
public class SpringbootNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootNacosApplication.class,args);
    }
}

