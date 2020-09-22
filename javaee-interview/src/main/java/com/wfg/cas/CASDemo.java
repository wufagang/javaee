package com.wfg.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * java
 *
 * @Title: com.wfg.cas
 * @Date: 2020/8/26 14:57
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class CASDemo {
    public static void main(String[] args) {
        //创建一个原子整型
        AtomicInteger atomicInteger = new AtomicInteger(5);

        /**
         * 一个是期望值，一个是更新值，但期望值和原来的值相同时，才能够更改
         * 假设三秒前，我拿的是5，也就是expect为5，然后我需要更新成 8
         */
        System.out.println(atomicInteger.compareAndSet(5,8));
        System.out.println(atomicInteger.compareAndSet(5,9));

    }
}
