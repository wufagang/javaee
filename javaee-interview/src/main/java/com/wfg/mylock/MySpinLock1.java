package com.wfg.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * javaee
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/9/26 8:04
 * @Author: wfg
 * @Description:
 * @Version:时过多日 自己写一下是否能写出来
 */
public class MySpinLock1 {
    final  static AtomicReference<Thread>  atomicReference = new AtomicReference<>();


    public static void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"尝试获取锁");
        while (!atomicReference.compareAndSet(null,thread)){

        }
        System.out.println(thread.getName()+"获取到锁");

    }

    public static void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"解锁开始");
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"解锁成功");
    }


    public static void main(String[] args) {
        new Thread(()->{
            MySpinLock1.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MySpinLock1.unlock();
        },"t1").start();

        new Thread(()->{
            MySpinLock1.lock();
            MySpinLock1.unlock();
        },"t2").start();
    }



}
