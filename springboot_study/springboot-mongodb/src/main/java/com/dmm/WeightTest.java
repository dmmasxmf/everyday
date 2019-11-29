//package com.dmm;
//
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Random;
//
///**
// * @author Mr. Du
// * @explain
// * @createTime 2019/11/26 17:40
// * @motto The more learn, the more found his ignorance.
// */
//
//public class WeightTest {
//
//    public <T> randomKey(List<T> list, Random random){
//        //按照权重排序
//        Collections.sort(list,new Comparator<T>() {
//            @Override
//            public int compare(T o1, T o2) {
//                if(o1.getWeight()<o2.getWeight()){
//                    return -1;
//                }else if(o1.getWeight()>o2.getWeight()){
//                    return 1;
//                }
//                return 0;
//            }
//        });
//        int sum = 0;
//        for(T object:list){
//            sum += object.getWeight();
//        }
//        int randomNumber = random.nextInt(sum);
//        T target = null;
//        for(T object:list){
//            randomNumber -= object.getWeight();
//            if(randomNumber <=0){
//                target = object;
//                break;
//            }
//        }
//        return target;
//    }
//}
//
