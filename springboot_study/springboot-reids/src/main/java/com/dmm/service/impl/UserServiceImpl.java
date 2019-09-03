package com.dmm.service.impl;

import com.dmm.entry.User;
import com.dmm.entry.UserExample;
import com.dmm.mapper.UserMapper;
import com.dmm.service.UserService;
import com.dmm.util.LockUtil;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LockUtil lockUtil;

    @Override
    public String modifyUser(User user) {
        String value=UUID.randomUUID().toString();
        try {

            System.out.println(user.getId().toString());
            if(!lockUtil.lock(user.getId().toString(),value)){
                return "并发量太多了，换个姿势再试试！";
            }
            /*****如果被锁，则下面的代码都不会被执行*******/

            UserExample userExample=new UserExample();
            userExample.createCriteria().andIdEqualTo(user.getId());
            System.out.println(System.currentTimeMillis()+"--");
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis()+"++");
            int i=userMapper.updateByExampleSelective(user,userExample);
            if(i==1){
               return "并发量不是太多了，换个姿势再试试！";
            }
            return "后台出错了1";
        } catch (Exception e) {
            e.printStackTrace();
            return "后台出错了2";
        }finally {
            lockUtil.unlock(user.getId().toString(),value);
        }

    }
}

