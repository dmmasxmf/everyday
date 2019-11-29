package com.dmm.rather.comparable.entry;

import com.dmm.rather.entry.Girl;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/29 14:17
 * @motto The more learn, the more found his ignorance.
 */

public class GirlSun extends Girl implements Comparable<Object> {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GirlSun{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        GirlSun girl=(GirlSun)o;
        /**
         * 比较属性必须是数字类型
         * 升序：this - u
         * 降序：u - this
         * 减数-被减数
         */

        //return this.getAge()-girl.getAge();
        return girl.getAge()-this.getAge();
    }
}

