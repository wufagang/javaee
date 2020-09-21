package com.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.TimeUnit;

/**
 * spring_annotation
 *
 * @Title: com.date
 * @Date: 2020/8/14 17:17
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo1 {

    /**
     * 2020-09-20
     * 2020-09-20T12:14:34
     * 2022-09-20
     * 2020-08-30
     * 2020
     * SEPTEMBER
     * 9
     * 20
     * SUNDAY
     * 264
     */
    @Test
    public void test1(){

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.of(2020, 9, 20, 12, 14, 34);
        System.out.println(localDateTime);

        LocalDate localDate1 = localDate.plusYears(2);
        System.out.println(localDate1);

        LocalDate localDate2 = localDate.minusDays(21);
        System.out.println(localDate2);

        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());

    }

    /**
     * Instant: 时间戳(以Unix 元年1970年1月1日00:00:00 到莫个时刻的时间毫秒值)
     */
    @Test
    public void test2(){

        Instant instant = Instant.now(); //默认获取UTC时区
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(instant.toEpochMilli());

        Instant instant1 = Instant.ofEpochMilli(60);
        System.out.println(instant1);

    }

    /**
     * duration 计算两个“时间”之间的间隔
     * period 计算两个“日期”之间的间隔
     */

    @Test
    public void test3(){

        Instant instant = Instant.now();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant1 = Instant.now();
        Duration duration = Duration.between(instant, instant1);
        System.out.println(duration.toMillis());

        System.out.println("----------------");

        LocalTime localTime = LocalTime.now();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime1 =  LocalTime.now();
        System.out.println(Duration.between(localTime, localTime1).toMillis());


        System.out.println("---------------------");

        LocalDate localDate = LocalDate.of(2015, 1, 1);
        LocalDate localDate1 =  LocalDate.now();
        Period period = Period.between(localDate, localDate1);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
    }

    /**
     * TemporalAdjuster : 时间校正器
     */
    @Test
    public void test5(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate localDate1 = localDate.withDayOfMonth(10);
        System.out.println(localDate1);

        LocalDate localDate2 = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        System.out.println(localDate2);
        //自定义下一个工作日

        LocalDate localDate4=localDate.with((l)->{
           LocalDate localDate3 = (LocalDate) l;
            DayOfWeek dayOfWeek = localDate3.getDayOfWeek();

            if(dayOfWeek.equals(DayOfWeek.FRIDAY)){
                return localDate3.plusDays(3);
            }else if (dayOfWeek.equals(DayOfWeek.SATURDAY)){
                return localDate3.plusDays(2);
            }else {
                return localDate.plusDays(1);
            }
        });
        System.out.println(localDate4);
    }

    /**
     * 格式化时间/日期
     */
    @Test
    public void test6(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDate localDate = LocalDate.now();
        String format = localDate.format(dtf);
        System.out.println(format);

        System.out.println("-----------------");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format1 = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format1);

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.parse(format1, dateTimeFormatter);
        System.out.println(localDate2);
    }

}
