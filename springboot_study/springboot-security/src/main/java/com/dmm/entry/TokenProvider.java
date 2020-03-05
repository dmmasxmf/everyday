package com.dmm.entry;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Mr. Du
 * @explain token的生产者
 * @createTime 2020/3/4 18:57
 * @motto The more learn, the more found his ignorance.
 */
@Repository
public class TokenProvider {

    private  String secretKey;
    private   int tokenValidity;
    public TokenProvider() {

    }

    public TokenProvider(String secretKey, int tokenValidity) {
        this.secretKey = secretKey;
        this.tokenValidity = tokenValidity;
    }
    // 生成token
    public Token createToken(UserDetails userDetails) {
        long expires = System.currentTimeMillis() + 1000L * tokenValidity;
        String token =  computeSignature(userDetails, expires);
        return new Token(token, expires);
    }
    // 验证token
    public boolean validateToken(String authToken, UserDetails userDetails) {
//        check token
//        return true or false;
        return true;
    }
    // 从token中识别用户
    public String getUserNameFromToken(String authToken) {
        // ……
        //return login;
        return "admin";
    }
    public String computeSignature(UserDetails userDetails, long expires) {
        // 一些特有的信息组装 ,并结合某种加密活摘要算法
        //return 例如 something+"|"+something2+MD5(s);
        return "123456";
    }
}

