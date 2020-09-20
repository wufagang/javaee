package com.wfg.heap;

import java.util.ArrayList;
import java.util.Random;

/**
 * java
 *
 * @Title: com.wfg.heap
 * @Date: 2020/9/3
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class HeapInstanceTest {

    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) {
        ArrayList<HeapInstanceTest> list = new ArrayList<HeapInstanceTest>();
        while (true) {
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
