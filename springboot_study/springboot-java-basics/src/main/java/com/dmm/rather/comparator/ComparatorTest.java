package com.dmm.rather.comparator;

import com.dmm.rather.comparator.entry.GirlSun;

import java.util.*;

/**
 *
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/29 14:12
 * @motto The more learn, the more found his ignorance.
 */

public class ComparatorTest {

    public static void main(String[] args) {

        Set<GirlSun> girlSunSet=new TreeSet<>(new GirlComparator());

        GirlSun girlSun;

        for (int i=0;i<50;i++){

            girlSun=new GirlSun();
            girlSun.setName("杜明明-->"+i);
            girlSun.setAge(i);

            girlSunSet.add(girlSun);
        }
        //Collections.shuffle(girlSunSet);
        girlSunSet.stream().forEach(System.out::println);


    }

//    static class GirlComparator implements Comparator<GirlSun>{
//
//        @Override
//        public int compare(GirlSun o1, GirlSun o2) {
//            return o1.getAge()-o2.getAge();
//        }
//    }
}

