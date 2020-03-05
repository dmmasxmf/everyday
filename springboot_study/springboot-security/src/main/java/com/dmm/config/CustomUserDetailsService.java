package com.dmm.config;

import com.dmm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/3 15:40
 * @motto The more learn, the more found his ignorance.
 */
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        com.dmm.entry.User userFromDatabase=userMapper.selectByLogin(login);

        if (userFromDatabase == null) {
            //log.warn("User: {} not found", login);
            throw new UsernameNotFoundException("User " + login + " was not found in db");
            //这里找不到必须抛异常
        }
        Collection<GrantedAuthority> grantedAuthorities=new ArrayList<>();

        //角色插入
        GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(userFromDatabase.getRole());
        GrantedAuthority grantedAuthority2=new SimpleGrantedAuthority("ROLE_USER");
        grantedAuthorities.add(grantedAuthority);
        grantedAuthorities.add(grantedAuthority2);
        return new User(login,userFromDatabase.getPassword(),grantedAuthorities);

    }
}

