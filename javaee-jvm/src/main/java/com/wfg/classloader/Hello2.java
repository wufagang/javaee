package com.wfg.classloader;

/**
 * java
 *
 * @Title: com.wfg.classloader
 * @Date: 2020/8/29 14:28
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Hello2 {
   static class Father{
       static int A=1;
       static {
           A=3;
       }

   }
   static class Son extends Father {
       private static int B = A;
   }

    public static void main(String[] args) {
       //3
        System.out.println(Son.B);
    }


}
