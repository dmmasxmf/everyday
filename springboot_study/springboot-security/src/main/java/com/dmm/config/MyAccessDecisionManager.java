package com.dmm.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/5 15:37
 * @motto The more learn, the more found his ignorance.
 */

public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

        //这段代码其实不需要,因为spring-security-core-4.1.4.RELEASE-sources.jar!/org/springframework/security/access/intercept/AbstractSecurityInterceptor.java第215行判断提前返回了,不会进入decide方法
        if (CollectionUtils.isEmpty(collection)) {
            throw new AccessDeniedException("not allow");
        }
        //路径对应的角色
        Iterator<ConfigAttribute> ite = collection.iterator();
        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            String needRole = (ca).getAttribute();
            System.out.println(needRole+"---++++++-------");
            //系统所存的角色
            System.out.println(authentication.getAuthorities().size()+"++++++++++++++++++++++++++++++++");

            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if(ga.getAuthority().equals(needRole)){
                    //匹配到有对应角色,则允许通过
                    return;
                }
            }
        }
        //该url有配置权限,但是当然登录用户没有匹配到对应权限,则禁止访问
        throw new AccessDeniedException("not allow");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

