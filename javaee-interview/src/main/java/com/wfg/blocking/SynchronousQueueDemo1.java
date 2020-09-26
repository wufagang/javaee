package com.wfg.blocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * javaee
 *
 * @Title: com.wfg.blocking
 * @Date: 2020/9/26 20:16
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class SynchronousQueueDemo1 {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "\t put A");
                blockingQueue.put("A");
                System.out.println(Thread.currentThread().getName() + "\t put B");
                blockingQueue.put("B");
                System.out.println(Thread.currentThread().getName() + "\t put C");
                blockingQueue.put("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        //消费线程使用take，消费阻塞队列中的内容，并且每次消费前，都等待5秒
        new Thread(()->{
            try {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t take A");
                System.out.println(blockingQueue.take());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t take B");
                System.out.println(blockingQueue.take());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t take C");
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
}
