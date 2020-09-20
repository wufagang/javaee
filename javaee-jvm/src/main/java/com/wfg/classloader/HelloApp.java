package com.wfg.classloader;

/**
 * java
 *
 *
 * @Title: com.wfg.classloader
 * @Date: 2020/8/29 12:07
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class HelloApp {
    //在prepare阶段: a=0  ----> initial阶段: a=1
    private static int a=1;
    static{
        a=2;
        b=30;
        System.out.println(a);
        //Illegal forward reference
        //非法前置引用
        //System.out.println(b);
    }
    //private static int a=1;
    private static int b=10;

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
    }
}
