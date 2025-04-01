package com.frank.googleguava;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author: kst
 * @date: 2024/12/18 17:15
 */
public class StopwatchTest {

    public static void main(String[] args) throws Exception {
        // 创建并启动定时器
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        Thread.sleep(1000L);
//        long elapsed = stopwatch.stop().elapsed(TimeUnit.MILLISECONDS);
//        System.out.println("耗时=" + elapsed + "毫秒");


        // 创建未启动的定时器
//        Stopwatch stopwatch = Stopwatch.createUnstarted();
//        stopwatch.start();
//        Thread.sleep(2000L);
//        stopwatch.stop();
//        long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
//        System.out.println("耗时=" + elapsed + "毫秒");


        // 重置定时器
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        Thread.sleep(2000L);
//        stopwatch.stop();
//        stopwatch.reset();
//        stopwatch.start();
//        Thread.sleep(5000L);
//        long elapsed = stopwatch.stop().elapsed(TimeUnit.MILLISECONDS);
//        System.out.println("耗时=" + elapsed + "毫秒");


        // 检查计时器是否运行中
//        Stopwatch stopwatch = Stopwatch.createStarted();
//        Thread.sleep(2000L);
//        boolean running = stopwatch.isRunning();
//        System.out.println(running);
//        stopwatch.stop();


        // 以字符串形式输出经过的时间
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(2000L);
        String s = stopwatch.stop().toString();
        System.out.println(s);
    }
}
