package com.dmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DMM
 * @create 2019/7/24
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String show(Model model){

        model.addAttribute("name","力王");

        return "index";
    }
    @RequestMapping("/up")
    public String ff(){
       return "up";
    }


}

