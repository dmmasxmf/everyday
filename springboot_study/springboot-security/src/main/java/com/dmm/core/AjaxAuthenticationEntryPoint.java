package com.dmm.core;

import com.alibaba.fastjson.JSON;
import com.dmm.entry.ResultVO;
import com.dmm.util.ResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr. Du
 * @explain 用户未登录时返回给前端的数据
 * @createTime 2020/3/5 16:45
 * @motto The more learn, the more found his ignorance.
 */
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_NEED_AUTHORITIES,false)));
    }
}

