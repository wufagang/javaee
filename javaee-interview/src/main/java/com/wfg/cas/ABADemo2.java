package com.wfg.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * java
 *
 * @Title: com.wfg.cas
 * @Date: 2020/8/26 13:06
 * @Author: wfg
 * @Description:
 * @Version:ABA问题解决方案
 * 类似于svn或者git添加版本号进行比较版本号的大小
 */
public class ABADemo2 {


   static AtomicReference<Integer> referenceInteger = new AtomicReference<>(100);

   static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
       new Thread(()->{
           System.out.println("线程t1当前版本号:"+stampedReference.getStamp());
           try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
           System.out.println("线程t1当前版本号:"+stampedReference.getStamp());
           stampedReference.compareAndSet(101,102,stampedReference.getStamp(),stampedReference.getStamp()+1);
           System.out.println("线程t1当前版本号:"+stampedReference.getStamp());
           stampedReference.compareAndSet(102,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
           System.out.println("线程t1当前版本号:"+stampedReference.getStamp());
       },"t1").start();
       new Thread(()->{
           int stamp=stampedReference.getStamp();
           System.out.println("线程"+Thread.currentThread().getName()+"\t 版本号"+stamp);
            try {
              TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
           System.out.println(stampedReference.getReference());
           System.out.println(stampedReference.compareAndSet(100,2019,stamp,stamp+1));
       },"t2").start();

    }
}
