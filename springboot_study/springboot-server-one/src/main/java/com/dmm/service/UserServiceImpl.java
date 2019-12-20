package com.dmm.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.dmm.UserDao;
import com.dmm.entry.User;
import com.dmm.entry.UserExample;
import com.dmm.mapper.UserMapper;
import com.dmm.mapper.UserNoteMapper;
import com.dmm.service.interfaces.PersonService;
import com.dmm.service.interfaces.UserService;
//import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author DMM
 * @create 2019/7/29
 */
@Service
public class UserServiceImpl implements UserService {

    //xml的配置
    @Autowired
    private UserMapper userMapper;

    //jdbcTemplate的配置
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserNoteMapper userNoteMapper;

    public User getUser(long id) {

        UserExample userExample=new UserExample();

        return userMapper.selectByPrimaryKey(id);

    }

    @Override
    public int setUser(User user){
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> getList() {

        UserExample userExample=new UserExample();
        userExample.setOffset(0);
        userExample.setLimit(10);

        return userMapper.selectByExample(userExample);
    }

    @Override
    public String abc(){
        userDao.addUser();
        return "100";
    }
    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }
    @Override
    public List<User> getList(int page, int limit) {

        UserExample userExample=new UserExample();

        //相当于拦截器，再返回的时候进行对应的返回
//        PageHelper.startPage(page,limit);


        return userMapper.selectByExample(userExample);

    }

    @Autowired
    PersonService personService;

    @Override
    @Transactional
    @LcnTransaction
    public void addUser(String name, String password) {

        userNoteMapper.addUser(name,password);

        try {
            //personService.addUser();
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1/0);
    }


    @Override
    public User findUser(String name) {
        return userNoteMapper.findUserByName(name);
    }




    @Override
    @Transactional
    public void addUser2(String name, String password) {

        userNoteMapper.addUser(name,password);

        try {
            personService.addUser();
        } catch (Exception e) {
            e.printStackTrace();
            ///throw e;
        }
    }

    @Override
    @Transactional
    public void test(){
        //userNoteMapper.addUser("ffv","fvdesdfcvsdf");
        //System.out.println(1/0);
        //System.out.println(1/0);
    }
}

