package com.dmm.controller;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/5/29 14:14
 * @motto The more learn, the more found his ignorance.
 */

public class TestMain {

    public static void main(String[] args) {
        AtomicLong atomicLong=new AtomicLong(1000L);

        System.out.println("atomicLong = " + atomicLong);
        atomicLong.set(10L);
        System.out.println("atomicLong = " + atomicLong);

        System.out.println("atomicLong.decrementAndGet() = " + atomicLong.decrementAndGet());

        System.out.println("atomicLong.getAndDecrement() = " + atomicLong.getAndDecrement());

        System.out.println("atomicLong.incrementAndGet() = " + atomicLong.incrementAndGet());

        System.out.println("atomicLong.getAndIncrement() = " + atomicLong.getAndIncrement());

        System.out.println("atomicLong = " + atomicLong);

        System.out.println("atomicLong.getAndAdd(1000000L) = " + atomicLong.getAndAdd(1000000L));

        System.out.println("atomicLong.addAndGet(1L) = " + atomicLong.addAndGet(1L));

        System.out.println("atomicLong.compareAndSet(1L,1000L) = " + atomicLong.compareAndSet(1L,1000L));

        System.out.println("atomicLong = " + atomicLong);

        System.out.println("atomicLong.getAndSet(1000L) = " + atomicLong.getAndSet(1000L));

        System.out.println("atomicLong = " + atomicLong);

        System.out.println("atomicLong.intValue() = " + atomicLong.intValue());

        System.out.println("atomicLong.longValue() = " + atomicLong.longValue());

        System.out.println("atomicLong.floatValue() = " + atomicLong.floatValue());

        System.out.println("atomicLong.doubleValue() = " + atomicLong.doubleValue());

        atomicLong.lazySet(10086L);
        System.out.println("atomicLong = " + atomicLong);

    }
}

