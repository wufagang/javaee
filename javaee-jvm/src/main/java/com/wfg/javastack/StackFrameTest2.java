package com.wfg.javastack;

import org.junit.Test;

/**
 * java
 *
 * @Title: com.wfg.javastack
 * @Date: 2020/9/1 18:12
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class StackFrameTest2 {
    private int a;

    public static void main(String[] args) {
        int i=3;
        int j=3;
        System.out.println(i);
    }

    private static void test1(){
        int a=2;
        int b=3;
        int c=8;
        System.out.println(a);
    }

    /**
     * 在局部变量表里，**32位以内的类型只占用一个slot**（包括returnAddress类型），**64位的类型（long和double）占用两个slot**。
     *     -- byte、short、char、float在存储前被转换为int，boolean也被转换为int，0表示false，非0表示true；
     *     -- long和double则占据两个slot。
     */
    private static void test2(){
        int a=2;     //0
        double b=3;  //1 2
        long c =4;   // 3 4
        float d =2;  // 5
        int m = 1;   //6
        System.out.println(a);
    }

    /**
     * 如果当前帧是由**构造方法或者实例方法**创建的，那么**该对象引用this将会存放在index为0的slot处,其余的参数按照参数表顺序排列。**
     */

    public StackFrameTest2(){
        int a=1;
        this.a=3;
        System.out.println(this.a);
    }

    public void test3(){
        a=3;
        System.out.println(this.a);
    }


    private void test4() {
        int a = 0;
        {
            int b = 0;
            b = a+1;
        }
        //变量c使用之前以及经销毁的变量b占据的slot位置
        int c = a+1;
    }

    @Test
    public void test5(){
        //第一类问题
       int i12=9;
       i12++;
        //第二类问题
        int i2=20;
       int i3 = i2++;
        //第三类问题
        int i4=40;
        i4=i4++;

        //第四类问题
        int i5=50;
        int i6=i5++ + ++i5;
        System.out.println(i12);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);
        System.out.println(i6);
    }

    private void test6(){
        int i1=10;
        ++i1;

        //第二类问题
        int i2=20;
        int i3 = ++i2;
//第三类问题
        int i4=40;
        i4=++i4;

    }























}
