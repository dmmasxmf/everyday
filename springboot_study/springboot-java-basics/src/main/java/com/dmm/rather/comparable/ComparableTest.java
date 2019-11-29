package com.dmm.rather.comparable;

import com.dmm.rather.comparable.entry.GirlSun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ComparableTest 理解
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/29 14:11
 * @motto The more learn, the more found his ignorance.
 */

public class ComparableTest {

    public static void main(String[] args) {

        List<GirlSun> girlSunList=new ArrayList<>(100);

        GirlSun girlSun;

        for (int i=0;i<75;i++){

            girlSun=new GirlSun();
            girlSun.setName("杜明明-->"+i);
            girlSun.setAge(i);

            girlSunList.add(girlSun);
        }

        Collections.shuffle(girlSunList);
        girlSunList.stream().forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        Collections.sort(girlSunList);
        girlSunList.stream().forEach(System.out::println);
    }
}

