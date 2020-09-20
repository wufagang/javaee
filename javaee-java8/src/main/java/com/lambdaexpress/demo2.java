package com.lambdaexpress;

import org.junit.Test;

/**
 * spring_annotation
 *
 * @Title: com.lambdaexpress
 * @Date: 2020/8/13 11:08
 * @Author: wfg
 * @Description:
 * @Version:
 */

interface Action {
    void eat();
}

public class demo2 {

    @Test
    public void test1(){
        Action action = new Action() {
            @Override
            public void eat() {
                System.out.println("吃苹果");
            }
        };
        action.eat();

        System.out.println("上面是传统写法;下面是lambda表达式");

        Action action1 =()-> System.out.println("吃苹果");
        action1.eat();


    }




}
