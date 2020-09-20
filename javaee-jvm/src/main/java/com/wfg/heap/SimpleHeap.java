package com.wfg.heap;

/**
 * java
 *
 * @Title: com.wfg.heap
 * @Date: 2020/9/3 5:37
 * @Author: wfg
 * @Description:
 * @Version:
 */

public class SimpleHeap {
    private int id;//属性、成员变量

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show() {
        System.out.println("My ID is " + id);
    }
    public static void main(String[] args) {
        SimpleHeap sl = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);

        int[] arr = new int[10];

        Object[] arr1 = new Object[10];
    }
}

