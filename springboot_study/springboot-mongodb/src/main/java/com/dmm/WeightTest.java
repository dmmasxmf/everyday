package com.dmm;

import java.util.*;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/26 17:40
 * @motto The more learn, the more found his ignorance.
 */

public class WeightTest{


    /**
     * 权重算法
     * @param list
     * @param random
     * @return
     */
    private ShortMessageWeightVo randomKey(List<ShortMessageWeightVo> list, Random random){
        //按照权重排序
        Collections.sort(list,(o1, o2)->{

            if(o1.getWeight()<o2.getWeight()){
                return -1;
            }else if(o1.getWeight()>o2.getWeight()){
                return 1;
            }
            return 0;

        });
        int sum = 0;
        for(ShortMessageWeightVo object:list){
            sum += object.getWeight();
        }
        int randomNumber = random.nextInt(sum);
        ShortMessageWeightVo target = null;
        for(ShortMessageWeightVo object:list){
            randomNumber -= object.getWeight();
            if(randomNumber <=0){
                target = object;
                break;
            }
        }
        return target;
    }

    public static void main(String[] args) {

        List<ShortMessageWeightVo> shortMessageWeightVoList=new ArrayList<>(7);

        ShortMessageWeightVo shortMessageWeightVo1=new ShortMessageWeightVo();
        shortMessageWeightVo1.setWeight(2);
        shortMessageWeightVo1.setRequestUrl("杜明明9");
        ShortMessageWeightVo shortMessageWeightVo2=new ShortMessageWeightVo();
        shortMessageWeightVo2.setWeight(3);
        shortMessageWeightVo2.setRequestUrl("杜明明1");

        shortMessageWeightVoList.add(shortMessageWeightVo1);
        shortMessageWeightVoList.add(shortMessageWeightVo2);
//        for(int i=0;i<7;i++){
//            shortMessageWeightVo=new ShortMessageWeightVo();
//            shortMessageWeightVo.setRequestUrl("100qwertyuiop"+i);
//            shortMessageWeightVo.setWeight(i);
//            shortMessageWeightVoList.add(shortMessageWeightVo);
//        }

        WeightTest weightTest=new WeightTest();

        for(int i=0;i<10;i++){
            ShortMessageWeightVo shortMessageWeightVo0=weightTest.randomKey(shortMessageWeightVoList,new Random());
            System.out.println(shortMessageWeightVo0.toString());
        }

    }

}

