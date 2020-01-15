package com.dmm.exception;

import lombok.Data;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/24 16:15
 * @motto The more learn, the more found his ignorance.
 */
@Data
public class ErrorResponseEntity {

    private int code;
    private String message;

    public ErrorResponseEntity (){}

    public ErrorResponseEntity(int code,String message){
        this.code=code;
        this.message=message;
    }
}

