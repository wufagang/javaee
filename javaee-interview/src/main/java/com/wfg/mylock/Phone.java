package com.wfg.mylock;

/**
 * java
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/8/28 6:58
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Phone {


    public synchronized void sendSNS(){
        System.out.println(Thread.currentThread().getName()+"\"come in sendSMs() \"");
        sendMail();
    }

    private synchronized void sendMail(){
        System.out.println(Thread.currentThread().getName()+"come in sendMail()");
    }
}
