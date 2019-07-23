package com.zyx.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步任务类
 */
@Component
@Async //如果异步类里都是异步方法时，就不用每个方法都加@Async,直接在类上加一个就行
public class AsyncTask {

//    @Async
    public void task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时："+(end-begin));
    }

//    @Async
    public void task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时："+(end-begin));
    }

//    @Async
    public void task3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时："+(end-begin));
    }

    //以下是获取异步结果
    public Future<String> task4() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("任务4耗时："+(end-begin));
        return new AsyncResult<>("任务4");
    }

    public Future<String> task5() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("任务5耗时："+(end-begin));
        return new AsyncResult<>("任务5");
    }

    public Future<String> task6() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("任务6耗时："+(end-begin));
        return new AsyncResult<>("任务6");
    }

}
