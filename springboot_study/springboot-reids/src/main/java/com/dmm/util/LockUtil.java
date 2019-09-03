package com.dmm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author DMM
 * @create 2019/9/3
 */
@Component
public class LockUtil {

    @Value("${expire.time}")
    private long expireTime;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 上锁
     * @param key
     * @param value
     * @return
     */
    public boolean lock(String key,String value){

        ////相当于SETNX指令，setIfAbsent方法设置了返回true,没有设置返回false
        if(redisTemplate.opsForValue().setIfAbsent(key,value)){
            return redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
        }
        //假设currentValue=A   接下来并发进来的两个线程的value都是B  其中一个线程拿到锁,除非从始至终所有都是在并发（实际上这中情况是不存在的），只要开始时有数据有先后顺序，则分布式锁就不会出现“多卖”的现象
        //String currentValue = (String) redisTemplate.opsForValue().get(key);

        //如果锁过期  解决死锁
//        if(!StringUtils.isEmpty(currentValue) ){
//            String oldValue=(String) redisTemplate.opsForValue().getAndSet(key,value);
//            //获取上一个锁的时间，锁过期后，GETSET将原来的锁替换成新锁
//            if(!StringUtils.isEmpty(oldValue) && currentValue.equals(oldValue)){
//                return true;
//            }
//        }

        //拿到锁的就有执行权力，拿不到的只有重新再来，重新再来只得是让用户手动继续抢单
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key,String value){
        try {
            String currentValue =(String) redisTemplate.opsForValue().get(key);
            if(StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }



}

