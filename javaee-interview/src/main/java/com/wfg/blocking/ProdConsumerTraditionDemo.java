package com.wfg.blocking;

/**
 * javaee
 *
 * @Title: com.wfg.blocking
 * @Date: 2020/9/26 20:48
 * @Author: wfg
 * @Description:
 * @Version:
 */
/**
 * 生产者消费者 传统版
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减1，来5轮
 * @author: 陌溪
 * @create: 2020-03-16-21:38
 */
/**
 * 线程 操作 资源类
 * 判断 干活 通知
 * 防止虚假唤醒机制
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class myData{
    private int number=0;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    public void increment(){
        lock.lock();
        try {
            //但是我们在进行判断的时候，为了防止出现虚假唤醒机制，不能使用if来进行判断，而应该使用while
            while (number !=0){
                // number 不等于0 进行阻塞
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void subtract(){
        lock.lock();
        try {

            while (number!=1){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



}
public class ProdConsumerTraditionDemo {

    public static void main(String[] args) {
        // 高内聚，低耦合    内聚指的是，一个空调，自身带有调节温度高低的方法
        myData myData= new myData();
        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                myData.increment();
            }
        },"AA").start();

       new Thread(()->{
           for (int i = 0; i <5 ; i++) {
               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               myData.subtract();
           }
       },"BB").start();


    }




}
