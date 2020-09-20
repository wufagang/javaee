package com.stream;

import com.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * spring_annotation
 *
 * @Title: com.stream
 * @Date: 2020/8/13 14:12
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo1 {
    private List<Person> personLists = Arrays.asList(
            new Person("张三",23, 333f),
            new Person("李四",67, 444f),
            new Person("王五",78, 555f),
            new Person("王五",78, 555f),
            new Person("赵六",34, 666f));
    //创建流
    @Test
    public void test1(){
        //1可以通过Collection系列集合提供的stream()或者parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //2.通过Arrays中的静态方法stream()获取数组流
        Person[] people = new Person[10];
        Stream<Person> stream1 = Arrays.stream(people);

        //3.通过Stream 类中的静态方法of()
        Stream<String> stringStream = Stream.of("11", "bb", "cc");
        //4创建无限流
        //迭代
        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2);
        integerStream.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(()->Math.random())
                .limit(5).forEach(System.out::println);


    }

    @Test
    public void test2(){
        Stream<Person> personStream = personLists.stream().filter((e) -> {
            System.out.println("========"+e.getName());
            return e.getAge() > 35;
        });
        personStream.forEach(System.out::println);

        System.out.println("++++++++++");
        personLists.stream().limit(2).forEach(System.out::println);
        System.out.println("++++++++++");
        personLists.stream().skip(2).forEach(System.out::println);
        System.out.println("++++++++++");
        personLists.stream().distinct().forEach(System.out::println);
    }


    @Test
    public void test3(){
        Stream.of("aaa","bbb","ccc")
                .map((x)->x.toUpperCase())
                .forEach(System.out::println);

        personLists.stream()
                .map(Person::getName)
                .forEach(System.out::println);



    }
}
