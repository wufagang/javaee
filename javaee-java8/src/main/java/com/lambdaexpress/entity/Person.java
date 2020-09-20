package com.lambdaexpress.entity;

/**
 * javaee
 *
 * @Title: com.lambdaexpress.entity
 * @Date: 2020/9/20 12:05
 * @Author: wfg
 * @Description:
 * @Version:
 */
public interface Person {

    public String getName(String name);

    default int getAge(){return  23;};

    static void testStatic(){
        System.out.println("测试接口的静态方法");
    };
}
