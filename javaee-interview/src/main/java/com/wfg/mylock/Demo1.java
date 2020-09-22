package com.wfg.mylock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * java
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/8/28 5:52
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo1 {


    static ReentrantLock lock = new ReentrantLock();

    public static void test(){
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 1; i <=10 ; i++) {
            new Thread(()->{
                Demo1.test();
            },String.valueOf(i)).start();
        }
    }
}
