package com.wfg.mylock;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * javaee
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/9/26 12:09
 * @Author: wfg
 * @Description:
 * @Version:
 */

/**
 * 10个车抢3个停车位
 */
public class SemaphoreDemo1 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <=10; i++) {
            new Thread(()->{

                try {
                    //获取资源
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"开始占用车位");
                    try {
                        TimeUnit.SECONDS.sleep(new Random().nextInt(8));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放资源
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }

}
