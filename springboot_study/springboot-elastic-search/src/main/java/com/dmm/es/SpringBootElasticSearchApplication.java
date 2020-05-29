package com.dmm.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/5/12 10:43
 * @motto The more learn, the more found his ignorance.
 */
@SpringBootApplication(scanBasePackages = "com.dmm.es")
public class SpringBootElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticSearchApplication.class,args);
    }

//    public static void main(String[] args) {
//        LocalDateTime localDateTime=LocalDateTime.now();
//
//        LocalDateTime localDateTime1=LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN);
//
//        System.out.println(localDateTime);
//        System.out.println(localDateTime1);
//
//        Duration duration=Duration.between(localDateTime,localDateTime1);
//
//        System.out.println(duration.toDays());
//        System.out.println(duration.toMillis());
//        System.out.println(duration.toDays());
//
//        LocalDateTime localDateTime2=localDateTime.minusDays(-1);
//
//        System.out.println(
//                localDateTime2
//        );
//
//        String s="2020/5/27 17:42:06";
//
//        LocalDateTime localDateTime3=LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
//
//        System.out.println(localDateTime3);
//    }
}

