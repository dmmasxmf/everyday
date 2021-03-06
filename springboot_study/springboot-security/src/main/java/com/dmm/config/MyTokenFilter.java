package com.dmm.config;

import com.dmm.entry.TokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/5 10:58
 * @motto The more learn, the more found his ignorance.
 */

public class MyTokenFilter extends GenericFilterBean {

    private final Logger log = LoggerFactory.getLogger(MyTokenFilter.class);

    private final static String MYAUTH_TOKEN_HEADER_NAME = "my-auth-token";

    private UserDetailsService detailsService;

    private TokenProvider tokenProvider;

    public MyTokenFilter(UserDetailsService detailsService, TokenProvider tokenProvider) {
        this.detailsService = detailsService;
        this.tokenProvider = tokenProvider;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String authToken = httpServletRequest.getHeader(MYAUTH_TOKEN_HEADER_NAME);
            if (StringUtils.hasText(authToken)) {
                // 从自定义tokenProvider中解析用户
                String username = this.tokenProvider.getUserNameFromToken(authToken);
                // 这里仍然是调用我们自定义的UserDetailsService，查库，检查用户名是否存在，
                // 如果是伪造的token,可能DB中就找不到username这个人了，抛出异常，认证失败
                UserDetails details = this.detailsService.loadUserByUsername(username);
                if (this.tokenProvider.validateToken(authToken, details)) {
                    log.info(" validateToken ok...");
                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, details.getPassword(), details.getAuthorities());
                    // 这里还是上面见过的，存放认证信息，如果没有走这一步，下面的doFilter就会提示登录了
                    SecurityContextHolder.getContext().setAuthentication(token);
                }
            }
            // 调用后续的Filter,如果上面的代码逻辑未能复原“session”，SecurityContext中没有想过信息，后面的流程会检测出"需要登录"
            chain.doFilter(request, response);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

