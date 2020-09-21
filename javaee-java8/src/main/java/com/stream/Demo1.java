package com.stream;

import com.entity.Person;
import jdk.net.SocketFlow;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
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


    /**
     * map接收Lambda，将元素转换成其它形式或提取信息，
     * 接收一个函数作为参数，该函数会被应用到每个元素上，
     * 并将其映射成一个新元素。flatMap 接收一个函数作为参数，
     * 将流中的每个值都转换成另一个流，然后把所有流连接成一个流。
     */
    @Test
    public void test3(){
        Stream.of("aaa","bbb","ccc")
                .map((x)->x.toUpperCase())
                .forEach(System.out::println);

        personLists.stream()
                .map(Person::getName)
                .forEach(System.out::println);

    }

    /**
     * sorted()：自然排序
     * sorted(Comparator com)：定制排序
     */
    @Test
    public void test4(){
        // 自然排序
        List<String> list = Arrays.asList( "bbb", "ccc" ,"aaa", "ddd");
        list.stream().sorted().forEach(System.out::println);

        //定制排序

        // 定制排序
        personLists.stream().sorted((person1,person2)->{
            if(person1.getAge()==person2.getAge()){
                return 0;
            }else {
                return person1.getAge()-person2.getAge();
            }
        }).forEach(System.out::println);

    }


    /**
     * allMatch：检查是否匹配所有元素
     * anyMatch：检查是否至少匹配一个元素
     * noneMatch：检查是否一个都没匹配
     * findFirst：返回第一个元素
     * findAny：返回当前流中任意一个元素
     * count：返回流中元素的个数
     * max：返回当前流中最大值
     * min：返回当前流中最小值
     * forEach：内部迭代
     */
    @Test
    public void test5(){
        boolean b=personLists.stream().allMatch((person)->{
            return person.getAge()>40;
        });
        System.out.println(b);

        boolean b2=personLists.stream().anyMatch((person)->{
            return person.getAge()>40;
        });
        System.out.println(b2);

        boolean b3=personLists.stream().noneMatch((person)->{
            return person.getAge()>40;
        });
        System.out.println(b3);

        System.out.println(personLists.stream().findFirst());

        System.out.println(personLists.stream().findAny());

        System.out.println(personLists.stream().count());

        System.out.println(personLists.stream().max((person1, persion2) -> {
            return person1.getAge() - persion2.getAge();
        }));


    }

    /**
     * 可以将流中元素反复结合，得到一个新值
     *
     * 这个reduce，其实有点类似于Hadoop中的mapReduce，先做map操作，然后做reduce操作
     */
    @Test
    public void test6(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer integer =list.stream().reduce(  10,(x,y)->{
            return x+y;
        });
        System.out.println(integer);  //65


        Optional<Float> salOptional = personLists.stream().map(Person::getSalary).reduce(Float::sum);

        System.out.println(salOptional.get()); //2553.0
    }

    @Test
    public void test7(){
        // 收集放入list中
        List<String> list = personLists.stream().map(Person::getName).collect(Collectors.toList());
        list.forEach(System.out::println);


        Set<String> strings=  personLists.stream().map(Person::getName).collect(Collectors.toSet());
        System.out.println(strings);

        HashSet<String> hashSet = personLists.stream().map(Person::getName).collect(Collectors.toCollection(HashSet::new));
        System.out.println(hashSet);

    }


    @Test
    public void test8(){
        //总数
        Long ages = personLists.stream().collect(Collectors.counting());
        System.out.println(ages);

        //平均数
        Double floatsal = personLists.stream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println(floatsal);

        //合计
        Double sumsal = personLists.stream().collect(Collectors.summingDouble(Person::getSalary));
        //最大值
        Optional<Person> max = personLists.stream().collect(Collectors.maxBy((p1,p2)->Float.compare(p1.getSalary(),p2.getSalary())));
        System.out.println(max.get());
        //最小值
        Optional<Person> min = personLists.stream().collect(Collectors.minBy((p1,p2)->Float.compare(p1.getSalary(),p2.getSalary())));
        System.out.println(min.get());

    }


    @Test
    public void test9(){
        Map<Integer, List<Person>> listMap = personLists.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(listMap);
    }

    @Test
    public void test10(){
        Map<String, Map<String, List<Person>>> stringMapMap = personLists.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy((p) -> {
                    if (p.getAge() <= 35) {
                        return "青年";
                    } else if (p.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(stringMapMap);
    }

    @Test
    public void test11(){
        DoubleSummaryStatistics summaryStatistics = personLists.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getMax());
    }

    //分区
    @Test
    public void test12(){
        Map<Boolean, List<Person>> booleanListMap = personLists.stream().collect(Collectors.partitioningBy((p) ->
            p.getSalary() > 300f
        ));
        System.out.println(booleanListMap);
    }
    //连接
    @Test
    public void test13(){
        String collect = personLists.stream().map(Person::getName).collect(Collectors.joining(",", "@@@", "==="));
        System.out.println(collect);
    }
}
