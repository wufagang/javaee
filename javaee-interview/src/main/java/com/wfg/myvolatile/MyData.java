package com.wfg.myvolatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java
 *
 * @Title: com.wfg
 * @Date: 2020/8/22 16:25
 * @Author: wfg
 * @Description:
 * @Version:代码验证volatile的可见性
 */
class MyData{
    volatile int number=0;

    AtomicInteger atomicInteger = new AtomicInteger();
     void addto60(){
        this.number=60;
    }
    void add(){
//        try {
//            TimeUnit.MILLISECONDS.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        number++;

    }
    void addAtomicInteger(){
        atomicInteger.getAndIncrement();
    }


}
