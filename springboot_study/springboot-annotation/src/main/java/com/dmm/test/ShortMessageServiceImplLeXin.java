package com.dmm.test;

import org.springframework.stereotype.Service;

/**
 * 乐信消息处理
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/13 10:26
 * @motto The more learn, the more found his ignorance.
 */
@ShortMessageAnnotation("lexin")
@Service
public class ShortMessageServiceImplLeXin implements ShortMessageService {
    @Override
    public int getShortMessageBalance() {
        System.out.println("000000000000000000000000000000000000");
        return 0;
    }

    @Override
    public int sendShortMessage() {

        System.out.println("1111111111111111111111111111111111111");
        return 0;
    }
}

