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
public class YellowPerson implements Person {
    @Override
    public String getName(String name) {
        return name;
    }

//    @Override
//    public int getAge() {
//        return 34;
//    }

    public static void main(String[] args) {
        Person person = new YellowPerson();

        System.out.println(person.getName("dddd"));

        System.out.println(person.getAge());
        Person.testStatic();
    }
}
