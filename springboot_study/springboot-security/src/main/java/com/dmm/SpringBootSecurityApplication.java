package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/15 19:19
 * @motto The more learn, the more found his ignorance.
 * @EnableGlobalMethodSecurity(prePostEnabled = true)
 */
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication(scanBasePackages = "com.dmm")
@EntityScan("com.dmm.entry")
public class SpringBootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityApplication.class,args);
    }

}

