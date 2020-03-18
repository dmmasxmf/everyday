package com.dmm.controller;


import com.dmm.config.CustomUserDetailsService;
import com.dmm.entry.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/3 10:30
 * @motto The more learn, the more found his ignorance.
 */
@Controller
public class AppController {

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello ,spring security!";
    }


    @RequestMapping("/product/info")
    @ResponseBody
    String productInfo(){

        String currentUser = "";
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails) {
            currentUser = ((UserDetails)principl).getUsername();
        }else {
            currentUser = principl.toString();
        }


        return " some product info "+currentUser;
    }

    @RequestMapping("/admin/home")
    @ResponseBody
    /**
     * @PreAuthorize("hasRole('admin')")
     */
    //@PreAuthorize("hasRole('ROLE_admin')")
    String productInfo2(){

        return " admin home page ";
    }

    @RequestMapping("/db/home")
    @ResponseBody
    /**
     * @PreAuthorize("hasRole('admin')")
     */
    String productInfo3(){

        return " admin home page123 ";
    }

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Inject
    TokenProvider tokenProvider;

    @Inject
    private AuthenticationManager authenticationManager;

    @RequestMapping("/aa")
    @ResponseBody
    public String authorize(@RequestParam String username, @RequestParam String password) {

//        // 1 创建UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken token     = new UsernamePasswordAuthenticationToken(username, password);
//        // 2 认证
        Authentication authentication = this.authenticationManager.authenticate(token);
//        // 3 保存认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
//        // 4 加载UserDetails
        UserDetails details = this.userDetailsService.loadUserByUsername(username);
//        // 5 生成自定义token
        tokenProvider.createToken(details);

        return "qwert";
    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public String authorize1(@RequestParam String username, @RequestParam String password) {
//
//        return "qwert"+username+password;
//    }

}

