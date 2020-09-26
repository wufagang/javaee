package com.wfg.mylock;

import java.util.concurrent.CountDownLatch;

/**
 * javaee
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/9/26 11:29
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class CountDownLatchDemo1 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"同学下自习回家!");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println("班长最后走锁门...............");
    }

}
