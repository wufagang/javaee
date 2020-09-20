package com.wfg.classloader;

/**
 * java
 *
 * @Title: com.wfg.classloader
 * @Date: 2020/8/29 14:10
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Hello1 {

    private static int a=1;
    static {
        a=10;
    }


    public static void main(String[] args) {
        System.out.println(a);
    }
}
