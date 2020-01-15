package com.dmm.exception;

/**
 * @author Mr. Du
 * @explain 自定义异常
 * @createTime 2019/12/24 16:13
 * @motto The more learn, the more found his ignorance.
 */

public class CustomException extends RuntimeException{

    private static final long serialVersionUID = 4564124491192825748L;

    private int code;

    public CustomException() {
        super();
    }

    public CustomException(int code, String message) {
        super(message);
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

