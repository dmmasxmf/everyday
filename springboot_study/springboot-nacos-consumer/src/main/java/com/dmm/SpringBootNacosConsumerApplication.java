package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/15 14:23
 * @motto The more learn, the more found his ignorance.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootNacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNacosConsumerApplication.class,args);
    }
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

