package com.dmm;

import java.util.Random;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/26 17:49
 * @motto The more learn, the more found his ignorance.
 */

public class AAA  {

    public static void main(String[] args) {
        Random random=new Random(System.currentTimeMillis());
        for(int i = 0; i < 10; i++){
            System.out.print(random.nextInt(2) + 1);
        }
    }
}

