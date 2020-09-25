package com.wfg.myLongAdder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * javaee
 *
 * @Title: com.wfg.myLongAdder
 * @Date: 2020/9/23 6:31
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class testAtomicLongAdder {

    public static void main(String[] args) throws InterruptedException {
        testAtomicLongAdder(1,10000000);
        testAtomicLongAdder(10,10000000);
        testAtomicLongAdder(100,10000000);

    }

    public static void testAtomicLongAdder(int threads, int times) throws InterruptedException {
        System.out.println("线程数:"+ threads+ "; 累加次数: " + times);
        long startAtomic = System.currentTimeMillis();
        testTtomicLong(threads,times);
        long endTomic = System.currentTimeMillis();

        long startLongadder = System.currentTimeMillis();
        testLongAdder(threads,times);
        long endLongadder = System.currentTimeMillis();
        System.out.println("AtomicLong 耗时:" + (endTomic-startAtomic) + "\n LongAdder 耗时: " + (endLongadder-startLongadder));
        System.out.println("---------------------");
    }
    private static void testTtomicLong(int threads, int times) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(0);
        List<Thread> list = new ArrayList<>();
        for (int i = 1; i <=threads; i++) {
            list.add(new Thread(()->{
                for (int j = 0; j < times; j++) {
                    atomicLong.incrementAndGet();
                }
            }));

        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }

        System.out.println("AtomicLong value is : " + atomicLong.get());
    }
    private static void testLongAdder(int threads, int times) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    longAdder.increment();
                }
            }));
        }

        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }

        System.out.println("LongAdder value is : " + longAdder.longValue());

    }


}
