package com.wfg.classloader;

import java.sql.DriverManager;

/**
 * java
 *
 * @Title: com.wfg.jvm.classloader
 * @Date: 2020/8/29 10:07
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class ClassLoaderDemo2 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Class.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = Class.forName("java.lang.String").getClassLoader();
        System.out.println(classLoader1);


        ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader3);

    }
}
