package com.wfg.stringtable;

import org.junit.Test;

/**
 * java
 *
 * @Title: com.wfg.stringtable
 * @Date: 2020/9/9 18:15
 * @Author: wfg
 * @Description:
 * @Version:
 */
/**
 * 如何保证变量s指向的是字符串常量池中的数据呢？
 * 有两种方式：
 * 方式一： String s = "shkstart";//字面量定义的方式
 * 方式二： 调用intern()
 *         String s = new String("shkstart").intern();
 *         String s = new StringBuilder("shkstart").toString().intern();
 *
 */


public class DemoIntern {


    @Test
    public void test1(){
        String s1="abc".intern();
        String s2="abc".intern();
        System.out.println(s1==s2);

        s1=s1+"ddd";

        System.out.println(s1==s2);
    }

    @Test
    public void test2(){
        String s1=new String("abc");
        String s2=new String("abc");
        System.out.println(s1==s2);

        String s3=new String("bcd").intern();
        String s4=new String("bcd").intern();
        System.out.println(s3==s4);
        System.out.println(s1==s4);

        String s5="bcd";
        System.out.println(s5==s3);
        System.out.println(s5==s4);
    }


    @Test
    public void test3(){
        String s1 = new String("a");
        s1.intern();
        String s2 = "a";
        System.out.println(s1==s2);
        String s3 = new String("b")+new String("c");
        s3.intern();
        String s4 = "bc";
        System.out.println(s3==s4);

    }
}
