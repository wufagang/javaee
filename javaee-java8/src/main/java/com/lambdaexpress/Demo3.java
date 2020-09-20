package com.lambdaexpress;


/**
 * java
 *
 * @Title: com.lambdaexpress
 * @Date: 2020/8/23 9:33
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo3 {

    public static void main(String[] args) {
        MyFun myFun1 = (a, b) -> a + b;
        MyFun myFun2 = (a, b) -> a - b;
        MyFun myFun3 = (a, b) -> a * b;
        MyFun myFun4 = (a, b) -> a / b;

        System.out.println(myFun1.count(1,3));
        System.out.println(myFun2.count(1,3));
        System.out.println(myFun3.count(1,3));
        System.out.println(myFun4.count(1,3));

    }
}
