package com.wfg.mylock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * javaee
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/9/26 10:15
 * @Author: wfg
 * @Description:
 * @Version:
 */
class  MyCache{   //资源类
    /**
     * 创建一个读写锁
     * 它是一个读写融为一体的锁，在使用的时候，需要转换
     */
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Map<String,Object> map = new HashMap<>();
    // 写操作: 独占+原子性
    public void put(String key, Object value){

        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写操作");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "写操作完成" +value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    /**
     * 读操作 可以共享 增加吞吐量
     * @param key
     */
    public void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "======开始读操作");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object res = map.get(key);
            System.out.println(Thread.currentThread().getName() + "======读操作完成" + res);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <=5; i++) {
            final int tempi=i;
            new Thread(()->{
                myCache.put(tempi+"", tempi);
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <=5; i++) {
            final int tempi=i;
            new Thread(()->{
                myCache.get(tempi+"");
            },String.valueOf(i)).start();
        }

    }
}
