package com.dmm.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr. Du
 * @explain 动态权限
 * @createTime 2020/3/5 15:19
 * @motto The more learn, the more found his ignorance.
 */

public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    private final Map<String,String> urlRoleMap = new HashMap<String,String>(){{
        put("/open/**","ROLE_ANONYMOUS");
        put("/hello/**","ROLE_ANONYMOUS");
        put("/admin/**","ROLE_ADMIN");
        put("/product/**","ROLE_USER");
    }};

    /**
     * 匹配路径成功的角色， 设置角色 auth
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) o;
        String url = fi.getRequestUrl();
//        String httpMethod = fi.getRequest().getMethod();
        for(Map.Entry<String,String> entry:urlRoleMap.entrySet()){
            if(antPathMatcher.match(entry.getKey(),url)){
                //
                return SecurityConfig.createList(entry.getValue());
            }
        }
        //没有匹配到,默认是要登录才能访问 普通角色
        return SecurityConfig.createList("ROLE_USER");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
        //return false;
    }
}

