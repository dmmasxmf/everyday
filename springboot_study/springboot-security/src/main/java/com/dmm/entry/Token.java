package com.dmm.entry;

/**
 * @author Mr. Du
 * @explain token模板
 * @createTime 2020/3/5 10:53
 * @motto The more learn, the more found his ignorance.
 */

public class Token {

    private String token;

    private long expires;

    private Token(){}

    public Token(String token,long expires){
        this.token=token;
        this.expires=expires;
    }
}

