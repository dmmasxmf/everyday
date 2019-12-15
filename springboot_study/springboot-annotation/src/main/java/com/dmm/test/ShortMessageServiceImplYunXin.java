package com.dmm.test;

import org.springframework.stereotype.Service;

/**
 * 云信消息处理
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/13 10:22
 * @motto The more learn, the more found his ignorance.
 */
@Service
@ShortMessageAnnotation(value = "yunxin")
public class ShortMessageServiceImplYunXin implements ShortMessageService {

    @Override
    public int getShortMessageBalance() {
        System.out.println("5555555555555555555555555555555555");
        return 0;
    }

    @Override
    public int sendShortMessage() {

        System.out.println("66666666666666666666666666666666666");
        return 0;
    }
}

