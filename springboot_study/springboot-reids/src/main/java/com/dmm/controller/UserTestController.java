package com.dmm.controller;

import com.dmm.entry.User;
import com.dmm.service.impl.UserServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DMM
 * @create 2019/9/18
 */
@RestController
public class UserTestController {

    @Autowired
    private UserServiceTest userServiceTest;

    @PostMapping("/1")
    public String test(){
        return userServiceTest.test();
    }

    @PostMapping("/2")
    public boolean test2(@RequestBody User user){
        return userServiceTest.create(user);
    }

}

