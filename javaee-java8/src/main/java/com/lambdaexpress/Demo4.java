package com.lambdaexpress;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java
 *
 * @Title: com.lambdaexpress
 * @Date: 2020/8/24 9:44
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo4 {


    @Test
    public void test01(){
        //Consumer
        Consumer<Integer> consumer = (x) -> System.out.println("消费型接口" + x);
        //test
        consumer.accept(100);
    }

    @Test
    public void test2(){
        Supplier<String> s =() -> {
            return "ddd";
        };
        System.out.println(s.get());
    }

    /**
     * 供给型接口，供给功能如何实现
     */
    @Test
    public  void test3() {
        List<Integer> list = getNumList(10, () -> {
            Integer a =   (int)(Math.random() * 10);
            return a;
        });

        list.stream().forEach(System.out::println);
    }

    /**
     * 产生指定个数的整数
     * @param n
     * @return
     */
    public static List<Integer> getNumList(Integer n, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(supplier.get());
        }
        return list;
    }



    /**
     * 函数型接口
     * Function<T, R>
     */
    @Test
    public void test31() {
        String str = strHandler("abcdefg", (x) -> {
            return x.toUpperCase().substring(0, 5);
        });
        System.out.println(str);
    }

    /**
     * 需求：用于处理字符串
     */
    public static String strHandler(String str, Function<String, String> function) {
        // 使用apply方法进行处理，怎么处理需要具体实现
        return function.apply(str);
    }

    /**
     * 断言型接口(把长度大于3的str过滤出来)
     */
    @Test
    public  void test4() {
        List<String> list = Arrays.asList("abc", "abcd", "df", "cgg", "aaab");
        List<String> result = strPredict(list, (x) -> x.length() > 3);
        result.forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 将满足条件的字符串，放入到集合中
     */
    public static List<String> strPredict(List<String> list, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        list.forEach(item -> {
            if(predicate.test(item)) {
                result.add(item);
            }
        });
        return result;
    }
}
