package com.wfg.heap;

/**
 * java
 *
 * @Title: com.wfg.heap
 * @Date: 2020/9/3
 * @Author: wfg
 * @Description:
 * @Version:
 */

/**
 * – -Xms 用于表示堆的起始内存，等价于 -XX:InitialHeapSize
 * -Xms 用来设置堆空间（年轻代+老年代）的初始内存大小
 * X 是jvm的运行参数
 * ms 是memory start
 * – -Xmx 用于设置堆的最大内存，等价于 -XX:MaxHeapSize
 */

/**
 * jvm  设置  -Xms10m -Xmx10m
 *
 * -Xms : 9M
 * -Xmx : 9M
 *
 *
 */

public class HeapSpaceInitial {
    public static void main(String[] args) {

        //返回Java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //返回Java虚拟机试图使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms : " + initialMemory + "M");//-Xms : 245M
        System.out.println("-Xmx : " + maxMemory + "M");//-Xmx : 3641M

        System.out.println("系统内存大小为：" + initialMemory * 64.0 / 1024 + "G");//系统内存大小为：15.3125G
        System.out.println("系统内存大小为：" + maxMemory * 4.0 / 1024 + "G");//系统内存大小为：14.22265625G

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

