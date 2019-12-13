package com.dmm.annotation;

import java.lang.annotation.*;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/12 20:02
 * @motto It's never too late to learn.
 */
@Target(ElementType.TYPE)  //作用在类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited  //子类可以继承此注解
public @interface HandlerOrderType {
    /**
     * 策略类型
     * @return
     */
    int value();
}
