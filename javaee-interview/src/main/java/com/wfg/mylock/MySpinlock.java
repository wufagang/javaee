package com.wfg.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * java
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/8/29 17:14
 * @Author: wfg
 * @Description:
 * @Version:
 */

/**
 * 手写一个自旋锁
 *
 * 循环比较获取直到成功为止，没有类似于wait的阻塞
 *
 * 通过CAS操作完成自旋锁，A线程先进来调用myLock方法自己持有锁5秒，B随后进来发现当前有线程持有锁，不是null，所以只能通过自旋等待，
 * 直到A释放锁后B随后抢到
 */
 public class MySpinlock {

    AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();
    public void myLock(){

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+" 尝试获取锁");
        while (!threadAtomicReference.compareAndSet(null,thread)){

        }
        System.out.println(thread.getName()+" ================获取锁成功");
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        threadAtomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+" *****************释放锁成功");
    }

    public static void main(String[] args) {
        MySpinlock mySpinlock = new MySpinlock();
        new Thread(()->{
            mySpinlock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySpinlock.myUnLock();
        },"t1").start();

        new Thread(()->{
            mySpinlock.myLock();

            mySpinlock.myUnLock();
        },"t2").start();
    }



}
