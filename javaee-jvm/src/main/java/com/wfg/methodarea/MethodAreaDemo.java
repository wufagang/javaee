package com.wfg.methodarea;

/**
 * java
 *
 * @Title: com.wfg.methodarea
 * @Date: 2020/9/6 8:56
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class MethodAreaDemo {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}

