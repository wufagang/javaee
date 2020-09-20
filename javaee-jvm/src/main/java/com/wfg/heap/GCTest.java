package com.wfg.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * java
 *
 * @Title: com.wfg.heap
 * @Date: 2020/9/5 17:51
 * @Author: wfg
 * @Description:
 * @Version:
 */
/** 测试GC分代回收
 * 测试MinorGC 、 MajorGC、FullGC
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 */
public class GCTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "testGC";
            while (true) {
                list.add(a);
                a = a + a;
                i++;

            }

        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("遍历次数为：" + i);
        }
    }
}
