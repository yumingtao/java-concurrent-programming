package com.ymt.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yumingtao
 */
public class MakeTea {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft2 = new FutureTask<>(new T2Task());
        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));

        Thread t1 = new Thread(ft1);
        t1.start();

        Thread t2 = new Thread(ft2);
        t2.start();

        String r1 = ft1.get();

        System.out.println(r1);
    }
}

/**
 * 洗水壶，烧水，泡茶
 */
class T1Task implements Callable<String> {

    FutureTask<String> ft;

    public T1Task(FutureTask<String> ft) {
        this.ft = ft;
    }

    @Override
    public String call() throws Exception {
        System.out.println("洗水壶");
        Thread.sleep(100);

        System.out.println("烧水");
        Thread.sleep(1500);

        String r = ft.get();

        System.out.println("泡茶:" + r);
        Thread.sleep(100);

        return "上茶";
    }
}

/**
 * 洗茶壶，洗茶杯，拿茶叶
 */
class T2Task implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("洗茶壶");
        Thread.sleep(100);

        System.out.println("洗茶杯");
        Thread.sleep(100);

        System.out.println("拿茶叶");
        Thread.sleep(100);

        return "铁观音";
    }
}