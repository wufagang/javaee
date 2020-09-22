package com.wfg.collection;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * java
 *
 * @Title: com.wfg.collection
 * @Date: 2020/8/27 11:09
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo1 {

    @Test
    public void test1(){
        //单线程是没问题问题的 我们非常熟悉
        List<String> list = new ArrayList<>();
        list.add("dd");
        list.add("aa");
        list.add("bb");
        list.forEach((item)->{
            System.out.println(item);
        });
    }



//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 1; i <=30 ; i++) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0, 8));
//                System.out.println(Thread.currentThread().getName()+"====" +list);
//            },String.valueOf(i)).start();
//        }
//    }

//    public static void main(String[] args) {
//        List<String> list=Collections.synchronizedList(new ArrayList<>());
//        /**
//         * 错误的写法
//         * List<String> list = new ArrayList<>();
//         * Collections.synchronizedList(list);
//         */
//
//        for (int i = 1; i <=30 ; i++) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0, 8));
//                System.out.println(Thread.currentThread().getName()+"====" +list);
//            },String.valueOf(i)).start();
//        }
//    }


    public static void main(String[] args) {

        List<String> list=new CopyOnWriteArrayList();
        /**
         * 错误的写法
         * List<String> list = new ArrayList<>();
         * Collections.synchronizedList(list);
         */

        for (int i = 1; i <=30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName()+"====" +list);
            },String.valueOf(i)).start();
        }
    }
}
