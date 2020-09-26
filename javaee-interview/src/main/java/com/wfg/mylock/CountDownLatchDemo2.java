package com.wfg.mylock;

import java.util.concurrent.CountDownLatch;

/**
 * javaee
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/9/26 11:34
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class CountDownLatchDemo2 {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6; i++) {
            //final int tempi=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"国被灭");
                countDownLatch.countDown();
            },CountDownLatchEnum.foreachEnum(i).getMsg()).start();
        }
        countDownLatch.await();
        System.out.println("秦国一统华夏");
    }
}
