package com.wfg.GC3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * java
 *
 * @Title: com.wfg.GC3
 * @Date: 2020/9/18 5:50
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class GCLogTest {

    /**
     * -Xms60m -Xmx60m -XX:+PrintGC
     * -Xms60m -Xmx60m -XX:+PrintGCDetails
     * -Xms60m -Xmx60m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
     * -Xms60m -Xmx60m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps
     * @param args
     */
    public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Byte[] bytes = new Byte[1024*100] ; //100k
            list.add(bytes);
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
