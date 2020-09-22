package com.wfg.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * java
 *
 * @Title: com.wfg.cas
 * @Date: 2020/8/26 13:06
 * @Author: wfg
 * @Description:
 * @Version:ABA问题演示
 */
public class ABADemo {


   static AtomicReference<Integer> referenceInteger = new AtomicReference<>(100);

    public static void main(String[] args) {
        //ABA问题的产生
        new Thread(()->{
            referenceInteger.compareAndSet(100,101);
            referenceInteger.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{
           try {
               //睡眠一秒确保线程t1进行完成
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
            System.out.println(referenceInteger.compareAndSet(100,2019));
        },"t2").start();

    }
}
