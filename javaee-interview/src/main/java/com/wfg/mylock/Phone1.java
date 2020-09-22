package com.wfg.mylock;

/**
 * java
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/8/29 17:04
 * @Author: wfg
 * @Description:
 * @Version:
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
public class Phone1 implements Runnable {
    Lock lock =new ReentrantLock();
    @Override
    public void run() {
        getLock();
    }

    /**
     * set进去的时候，就加锁，调用set方法的时候，能否访问另外一个加锁的set方法
     */
    public void getLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t get Lock");
            setLock();
        } finally {
            lock.unlock();
        }
    }

    public void setLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t set Lock");
        } finally {
            lock.unlock();
        }
    }
}
