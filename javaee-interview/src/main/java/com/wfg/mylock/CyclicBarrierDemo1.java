package com.wfg.mylock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * javaee
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/9/26 12:03
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class CyclicBarrierDemo1 {

    /**
     * 七珠召唤神龙
     * @param args
     */
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("神龙出现");
        });

        for (int i = 1; i <=7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"珠找到");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }



    }
}
