package com.dmm.rather.comparator;

import com.dmm.rather.comparator.entry.GirlSun;

import java.util.Comparator;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/29 15:06
 * @motto The more learn, the more found his ignorance.
 */

public class GirlComparator implements Comparator<GirlSun> {

    @Override
    public int compare(GirlSun o1, GirlSun o2) {
        /**
         * 二：数字比较
         * 升序：o1-o2
         * 降序：o2-o1
         */
        //return o1.getAge()-o2.getAge();

        return o2.getAge()-o1.getAge();
    }
}

