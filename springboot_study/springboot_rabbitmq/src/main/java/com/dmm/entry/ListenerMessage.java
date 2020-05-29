package com.dmm.entry;

import lombok.Data;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/4/20 9:15
 * @motto The more learn, the more found his ignorance.
 */
@Data
public class ListenerMessage<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态说明
     */
    private String message;

    private T data;

}

