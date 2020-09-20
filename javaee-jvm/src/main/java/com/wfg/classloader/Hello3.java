package com.wfg.classloader;

/**
 * java
 *
 * @Title: com.wfg.classloader
 * @Date: 2020/8/29 14:46
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Hello3 {
    public static void main(String[] args) {
        Runnable runnable=()->{
            System.out.println(Thread.currentThread().getName()+"开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName()+"结束");
        };

        Thread thread1 = new Thread(runnable, "线程1");
        Thread thread2 = new Thread(runnable, "线程2");
        thread1.start();
        thread2.start();
    }

}
class DeadThread{
    static {
        if(true){
            System.out.println(Thread.currentThread().getName()+"类初始化");
            while (true){}
        }
    }
}
