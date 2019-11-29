package com.dmm.rather.comparator.entry;

import com.dmm.rather.entry.Girl;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/29 14:55
 * @motto The more learn, the more found his ignorance.
 */

public class GirlSun extends Girl {

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
}

