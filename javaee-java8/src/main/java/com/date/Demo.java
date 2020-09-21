package com.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * javaee
 *
 * @Title: com.date
 * @Date: 2020/9/20 21:02
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo {

    public static void main(String[] args) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20161218");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(pool.submit(task));
        }
        for (Future<Date> future : futures  ) {
            System.out.println(future.get());
        }
    }
}
