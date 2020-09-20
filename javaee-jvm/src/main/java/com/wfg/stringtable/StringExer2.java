package com.wfg.stringtable;

/**
 * java
 *
 * @Title: com.wfg.stringtable
 * @Date: 2020/9/9 19:50
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class StringExer2 {
    public static void main(String[] args) {
        String s1 = new String("ab");//执行完以后，会在字符串常量池中会生成"ab"
//        String s1 = new String("a") + new String("b");////执行完以后，不会在字符串常量池中会生成"ab"
        s1.intern();
        String s2 = "ab";
        System.out.println(s1 == s2); //false
    }
}
