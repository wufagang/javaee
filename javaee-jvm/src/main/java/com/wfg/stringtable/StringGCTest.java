package com.wfg.stringtable;

/**
 * java
 *
 * @Title: com.wfg.stringtable
 * @Date: 2020/9/10 23:06
 * @Author: wfg
 * @Description:
 * @Version:
 */
/**
 * String的垃圾回收:
 * -Xms15m -Xmx15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
 *
 */
public class StringGCTest {
    public static void main(String[] args) {
//        for (int j = 0; j < 100; j++) {
//            String.valueOf(j).intern();
//        }
        //发生垃圾回收行为
        for (int j = 0; j < 100000; j++) {
            String.valueOf(j).intern();
        }
    }
}

