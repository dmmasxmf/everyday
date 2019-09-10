package com.dmm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * 一个要求，要求序列化和反序列化一致
 * @author DMM
 * @create 2019/9/5
 */
@Component
public class RedisTool {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * setNx 操作
     * @param key
     * @param value
     * @return
     */
    public boolean setNx(String key,String value){
        return redisTemplate.opsForValue().setIfAbsent(key,value);
    }

    /**
     * 设置过期时间
     * @param key
     * @param time
     * @param timeUnit
     */
    public boolean setExpire(String key, long time, TimeUnit timeUnit){
        return redisTemplate.expire(key,time,timeUnit);
    }

    /**
     * getAndSet 设置现有的值，返回原来的值 如果不存在 则返回nil
     * @param key
     * @param value
     * @return
     */
    public String setGetAndSet(String key,String value){
        return (String) redisTemplate.opsForValue().getAndSet(key,value);
    }

    /**
     * 是否存在key
     * @param key
     * @return
     */
    public boolean exist(String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public boolean delKey(String key){
        return redisTemplate.delete(key);
    }

    /**
     *  获取value
     * @param key
     * @return
     */
    public String getKey(String key){

        System.out.println(redisTemplate.getDefaultSerializer().toString()+"序列化默认");
        System.out.println(redisTemplate.getKeySerializer().toString()+"序列化key");
        System.out.println(redisTemplate.getValueSerializer().toString()+"序列化value");
        System.out.println(redisTemplate.getStringSerializer().toString()+"序列化String");

        System.out.println(redisTemplate.opsForValue().get(key).toString());

        //默认采用的是jdk的序列化  如果对象是字符串，就使用String
        return redisTemplate.opsForValue().get(key).toString();
    }

    /**
     * 获取key集合
     * @param pattern
     * @return
     */
    public Set getKeys(String pattern){
        return redisTemplate.keys(pattern);
    }

    /**
     * 获取过期时间
     * @param key
     * @param timeUnit
     * @return
     */
    public long getExpire(String key,TimeUnit timeUnit){
        return redisTemplate.getExpire(key,timeUnit);
    }

    /**
     * 原子递增
     * @param key
     * @param num
     * @return
     */
    public long incr(String key,long num){
        //redisTemplate.setValueSerializer(new StringRedisSerializer());
        //redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        // 默认采用的是jdk,基本类型没有进行序列化
        // 但是返回时采用的反序列化，
        // 基本类型无法和对象及String进行转化，存储的则是string

        return redisTemplate.opsForValue().increment(key,num);
    }

    /**
     * 设置值
     * @param key
     * @param value
     */

    public void set(String key,Object value){
        //如果不设置value的序列化，存入的值将发生使用 JdkSerializationRedisSerializer()进行序列化
        //不管任何对象，记录的包括类的信息

        //设置
        //redisTemplate.setValueSerializer(new StringRedisSerializer());
        //redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set(key,value);
    }

}

