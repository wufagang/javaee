package com.wfg.GC2;

/**
 * java
 *
 * @Title: com.wfg.GC2
 * @Date: 2020/9/15 21:43
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class SystemGCTest {

    public static void main(String[] args) {
        new SystemGCTest();
        System.gc();//提醒jvm的垃圾回收器执行gc,但是不确定是否马上执行gc
        //与Runtime.getRuntime().gc();的作用一样。
        //System.runFinalization();//强制调用使用引用的对象的finalize()方法
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("SystemGCTest 重写了finalize()");
    }
}
