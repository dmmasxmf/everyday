package com.dmm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/26 21:03
 * @motto The more learn, the more found his ignorance.
 */
@Configuration
@EnableRedisHttpSession
public class RedisConfig {

//    @Bean
//    public JedisConnectionFactory connectionFactory(){
//        return new JedisConnectionFactory();
//    }
}

