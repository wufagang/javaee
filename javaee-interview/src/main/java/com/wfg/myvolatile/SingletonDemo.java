package com.wfg.myvolatile;

/**
 * javaee
 *
 * @Title: com.wfg.myvolatile
 * @Date: 2020/9/22 6:50
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class SingletonDemo {

    private static volatile SingletonDemo singletonDemo=null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法");
    }
    //DCL模式 Double Check Lock 双端检索机制：在加锁前后都进行判断
    public static SingletonDemo getInstance(){
        if (singletonDemo==null){
            //singletonDemo=new SingletonDemo();
            synchronized (SingletonDemo.class){
                if (singletonDemo==null){
                    singletonDemo=new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i+1)).start();
        }
    }

}
