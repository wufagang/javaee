package com.wfg.GC2.gcreference;

/**
 * java
 *
 * @Title: com.wfg.GC2.gcreference
 * @Date: 2020/9/15 22:26
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer ("Hello,尚硅谷");
        StringBuffer str1 = str;

        str = null;
        System.gc();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(str1);
    }
}
