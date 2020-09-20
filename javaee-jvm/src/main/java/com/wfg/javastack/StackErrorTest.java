package com.wfg.javastack;

/**
 * java
 *
 * @Title: com.wfg.javastack
 * @Date: 2020/8/31 8:34
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class StackErrorTest {

    private static int count = 1;
    public static void main(String[] args) {
        /**
         *  默认情况下：count 10818  10713  11412  11404  11403
         *  设置栈的大小： -Xss256k count 2460   2470
         *  设置栈的大小： -Xss128k count 971  984
         *  设置栈的大小： -Xss108k count 968
         *设置栈的大小： -Xss16k  Could not create the Java Virtual Machine.
         * The stack size specified is too small, Specify at least 108k
         *
         *
         */
        System.out.println(count);
        count++;
        main(args);
    }
}
