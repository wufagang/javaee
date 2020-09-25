package com.wfg.myLongAdder;

import java.util.concurrent.atomic.LongAdder;

/**
 * javaee
 *
 * @Title: com.wfg.myLongAdder
 * @Date: 2020/9/22 20:28
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo1 {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
    }
}
