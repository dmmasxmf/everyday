package com.dmm.controller;

import com.dmm.entry.User;
import com.dmm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author DMM
 * @create 2019/9/3
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public String modify(@RequestBody User user, HttpSession httpSession){
        //Cookie cookie=new Cookie("ee","啊啊啊");
        //httpServletResponse.addCookie(cookie);
        //httpSession.setAttribute("dmm","最漂亮");
        return userService.modifyUser(user);
    }
}

