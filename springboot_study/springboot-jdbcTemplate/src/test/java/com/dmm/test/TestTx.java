package com.dmm.test;

import com.dmm.controller.UserController;
import com.dmm.service.interfaces.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/9 10:28
 * @motto The more learn, the more found his ignorance.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTx {

    @Autowired
    UserService userService;


    @Test
    public void addUser(){
        userService.addUser("晚上存储","菜单曾多次");
    }



    @Test
    public void addUser2(){
        userService.addUser2("晚上存储1bgvc","菜单曾多次");
    }

    @Autowired
    UserController userController;

    @Test
    public void addUser2Controller(){
        userController.list("vfdsvdervgde","rvgfdevggtf");
    }

}

