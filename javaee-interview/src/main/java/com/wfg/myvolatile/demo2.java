package com.wfg.myvolatile;

/**
 * java
 *
 * @Title: com.wfg
 * @Date: 2020/8/22 16:59
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class demo2 {

    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 1; i <=20 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.add();
                    myData.addAtomicInteger();
                }
            },String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){
            // yield表示不执行
            Thread.yield();
        }
        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 查看最终的值
        // 假设volatile保证原子性，那么输出的值应该为：  20 * 1000 = 20000
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.number);

        System.out.println(Thread.currentThread().getName() + "\t finally atomicInteger number value: " + myData.atomicInteger);
    }



}
