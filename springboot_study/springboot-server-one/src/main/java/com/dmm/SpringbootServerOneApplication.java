package com.dmm;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DMM
 * @create 2019/7/29
 */
@EnableDistributedTransaction
@SpringBootApplication
@MapperScan("com.dmm.mapper")//添加mapper层扫描 以防万一就添加上
public class SpringbootServerOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootServerOneApplication.class,args);
    }
}

