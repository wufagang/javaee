package com.wfg.methodarea;

/**
 * java
 *
 * @Title: com.wfg.methodarea
 * @Date: 2020/9/6 9:52
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class MethodAreaTest {
    public static void main(String[] args) {
        Order order = null;
        //以下代码不会报空指针异常
        order.hello();
        System.out.println(order.count);
    }
}

class Order {
    public static int count = 1;
    public static final int number = 2;


    public static void hello() {
        System.out.println("hello!");
    }
}