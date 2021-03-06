package com.dmm.controller;

import com.dmm.entry.User;
import com.dmm.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DMM
 * @create 2019/7/29
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    public String get(Model model){

        model.addAttribute("user",userService.getList().get(0));

        return "user";
    }

    @RequestMapping("/set")
    public String get(User user){

        userService.setUser(user);

        return "redirect:/user/info";
    }
    @RequestMapping("/from")
    public String index(){

        return "from";
    }

    @RequestMapping("/11")
    @ResponseBody
    public String cc(){
        return userService.abc();
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        User user=new User();
        user.setPassword("10000");
        user.setName("杜明明");
        user.setAge(1000000);
        userService.addUser(user);
        return "杜明明万岁";
    }

    @RequestMapping("/list/{page}/{limit}")
    @ResponseBody
    public List<User> list(@PathVariable int page,@PathVariable int limit){
        return userService.getList(page,limit);
    }



    @RequestMapping("/note/{name}/{password}")
    @ResponseBody
    public String list(@PathVariable String name,@PathVariable String password){
        try {
            userService.addUser2(name,password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        //userService.addUser2(name,password);
        return "完美";
    }
    @RequestMapping("/note/{name}/")
    @ResponseBody
    public User list(@PathVariable String name){

        return userService.findUser(name);
    }

    @RequestMapping("/qq/note/{name}/")
    @ResponseBody
    public List<User> list2(@PathVariable String name){

        User user=new User();
        user.setName("hhhhhhh");
        user.setPassword("10000000");
        user.setApikey("hnjkl");

        User user2=new User();
        user2.setName("hhhhhhh");
        user2.setPassword("10000000---------------");
        user2.setApikey("hnjkl");
        //return userService.findUser(name);

        List list=new ArrayList();
        list.add(user);
        list.add(user2);
        return list;
    }
}

