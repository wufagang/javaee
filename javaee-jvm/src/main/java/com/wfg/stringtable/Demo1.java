package com.wfg.stringtable;

import org.junit.Test;

/**
 * java
 *
 * @Title: com.wfg.stringtable
 * @Date: 2020/9/9 13:41
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo1 {


    /**
     *  -- 当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。

     */
    @Test
    public void test1(){
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1==s2); //true
        s1="word";
        System.out.println(s1==s2); //false
    }

    /**
     * * -- 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
     *
     */
    @Test
    public void test2(){
        String s1 = "hello";
        String s2 = "hello";
        String s3=s1+"world";
        System.out.println(s3==s2); //false

    }

    /**
     * * -- 当调用String的replace（）方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
     */

    @Test
    public void test3(){
        String s1 = "hello";
        String s2 = "hello";
        String s3=s1.replace("o","3");
        System.out.println(s3==s2); //false

    }
}
