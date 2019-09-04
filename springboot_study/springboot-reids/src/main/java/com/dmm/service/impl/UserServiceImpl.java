package com.dmm.service.impl;

import com.dmm.entry.User;
import com.dmm.entry.UserExample;
import com.dmm.mapper.UserMapper;
import com.dmm.service.UserService;
import com.dmm.util.LockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author DMM
 * @create 2019/9/3
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LockUtil lockUtil;

    @Override
    public String modifyUser(User user) {
        String value=UUID.randomUUID().toString();
        try {

            if(!lockUtil.lock(user.getId().toString(),value)){
                return "并发量太多了，换个姿势再试试！";
            }
            /*****如果被锁，则下面的代码都不会被执行*******/

            UserExample userExample=new UserExample();
            userExample.createCriteria().andIdEqualTo(user.getId());
            Thread.sleep(1000);
            log.debug("我是debug");
            // 如果没有捕获，只是在控制台显示而已 不会输出到日志中
            //System.out.println(1/0);
            int i=userMapper.updateByExampleSelective(user,userExample);
            if(i==1){
               return "并发量不是太多了，换个姿势再试试！";
            }
            return "后台出错了1";
        } catch (Exception e) {
            //e.printStackTrace();
            log.info("异常info->{} ",e.getMessage(),e);
            log.error("异常error->{} ",e.getMessage(),e);
            return "后台出错了2";
        }finally {
            lockUtil.unlock(user.getId().toString(),value);
        }

    }

    @Override
    public String test() {
//        try {
            System.out.println(1/0);
            log.debug("aa");
//        } catch (Exception e) {
            //e.printStackTrace();
            //log.error("错误是",e);
//        }
        return "万岁";
    }
}

