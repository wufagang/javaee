package com.wfg.mylock;

/**
 * java
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/8/28 6:57
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class ReenterLockDemo {

/**
 * 可重入锁（也叫递归锁）
 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取到该锁的代码，在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 * 也就是说：`线程可以进入任何一个它已经拥有的锁所同步的代码块`
 * */
//    public static void main(String[] args) {
//        Phone phone = new Phone();
//        for (int i = 1; i <=3 ; i++) {
//            new Thread(()->{
//                phone.sendSNS();
//            },String.valueOf(i)).start();
//        }
//
//
//
//    }

    public static void main(String[] args) {
        Phone1 phone = new Phone1();

        /**
         * 因为Phone实现了Runnable接口
         */
        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");
        t3.start();
        t4.start();
    }

}
